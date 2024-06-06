package com.example.technikonproject.repository;

import com.example.technikonproject.domain.PropertyRepair;
import com.example.technikonproject.dto.PropertyRepairAdminReportResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PropertyRepairRepository extends JpaRepository<PropertyRepair, Long> {
    
    List<PropertyRepair> searchPropertyRepairsByWebUserId(Long id);

    List<PropertyRepair> searchPropertyRepairsByDateOfScheduledRepairBetween(LocalDate dateStart, LocalDate dateEnd);

    @Query(value = """
        select new com.example.technikonproject.dto.PropertyRepairAdminReportResource(pr.repairType, pr.repairStatus, sum(pr.costOfRepair))
        from PropertyRepair pr
        where pr.webUser.id = :userId
        group by pr.repairStatus, pr.repairType
       """, nativeQuery = false)
    List<PropertyRepairAdminReportResource> getTotalCost(@Param ("userId") Long userId);//(@Param("id") Long id);


}
