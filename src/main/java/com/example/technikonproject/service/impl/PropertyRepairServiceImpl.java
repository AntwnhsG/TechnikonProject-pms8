package com.example.technikonproject.service.impl;

import com.example.technikonproject.domain.PropertyRepair;
import com.example.technikonproject.domain.WebUser;
import com.example.technikonproject.domain.enums.RepairStatus;
import com.example.technikonproject.domain.enums.RepairType;
import com.example.technikonproject.repository.PropertyRepairRepository;
import com.example.technikonproject.service.PropertyRepairService;
import com.example.technikonproject.dto.PropertyRepairAdminReportResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PropertyRepairServiceImpl extends BaseServiceImpl<PropertyRepair>
        implements PropertyRepairService {

    private final PropertyRepairRepository propertyRepairRepository;


    public PropertyRepairServiceImpl(PropertyRepairRepository propertyRepairRepository) {
        this.propertyRepairRepository = propertyRepairRepository;
    }

    @Override
    public JpaRepository<PropertyRepair, Long> getRepository() {
        return propertyRepairRepository;
    }

    @Override
    public PropertyRepair findPropertyRepair(Long id) {
        return propertyRepairRepository.findById(id).orElseThrow();
    }

    @Override
    public List<PropertyRepair> findPropertyRepairsByRangeOfDates(LocalDate dateStart, LocalDate dateEnd) {
        return propertyRepairRepository.searchPropertyRepairsByDateOfScheduledRepairBetween(dateStart, dateEnd);
    }

    @Override
    public List<PropertyRepair> findPropertyRepairsByWebUserId(Long id) {
        return propertyRepairRepository.searchPropertyRepairsByWebUserId(id);
    }

    @Override
    public List<PropertyRepairAdminReportResource> getTotalCost(Long userId){
        return propertyRepairRepository.getTotalCost(userId);
    }

    @Override
    public void updatePropertyRepair(PropertyRepair propertyRepair) {
        PropertyRepair propertyRepairOld = propertyRepairRepository.findById(propertyRepair.getId()).orElseThrow();
        propertyRepairOld.setRepairStatus(updatePropertyRepairStatus(propertyRepairOld, propertyRepair));
        propertyRepairOld.setCostOfRepair(updatePropertyCostOfRepair(propertyRepairOld, propertyRepair));
        propertyRepairOld.setRepairType(updatePropertyRepairType(propertyRepairOld, propertyRepair));
        propertyRepairOld.setWebUser(updatePropertyRepairWebUser(propertyRepairOld, propertyRepair));
        propertyRepairOld.setDateOfScheduledRepair(updatePropertyRepairDateOfScheduledRepair(propertyRepairOld, propertyRepair));
        propertyRepairOld.setDescription(updatePropertyRepairDescription(propertyRepairOld, propertyRepair));
        propertyRepairRepository.save(propertyRepairOld);
    }


    private RepairType updatePropertyRepairType(PropertyRepair propertyRepairOld, PropertyRepair propertyRepairNew) {
        if (propertyRepairNew.getRepairType() != null &&
                !propertyRepairNew.getRepairType().equals(propertyRepairOld.getRepairType()))
            return propertyRepairNew.getRepairType();
        return propertyRepairOld.getRepairType();
    }

    private RepairStatus updatePropertyRepairStatus(PropertyRepair propertyRepairOld, PropertyRepair propertyRepairNew) {
        if (propertyRepairNew.getRepairStatus() != null &&
                !propertyRepairNew.getRepairStatus().equals(propertyRepairOld.getRepairStatus())) {
            return propertyRepairNew.getRepairStatus();
        }
        return propertyRepairOld.getRepairStatus();
    }

    private BigDecimal updatePropertyCostOfRepair(PropertyRepair propertyRepairOld, PropertyRepair propertyRepairNew) {
        if (propertyRepairNew.getCostOfRepair() != null &&
                !propertyRepairNew.getCostOfRepair().equals(propertyRepairOld.getCostOfRepair())) {
            return propertyRepairNew.getCostOfRepair();
        }
        return propertyRepairOld.getCostOfRepair();

    }

    private WebUser updatePropertyRepairWebUser(PropertyRepair propertyRepairOld, PropertyRepair propertyRepairNew) {
        if (propertyRepairNew.getWebUser() != null &&
                !propertyRepairNew.getWebUser().equals(propertyRepairOld.getWebUser())) {
            return propertyRepairNew.getWebUser();
        }
        return propertyRepairOld.getWebUser();
    }

    private LocalDate updatePropertyRepairDateOfScheduledRepair(PropertyRepair propertyRepairOld, PropertyRepair propertyRepairNew) {
        if (propertyRepairNew.getDateOfScheduledRepair() == null &&
                propertyRepairNew.getDateOfScheduledRepair().isEqual(propertyRepairOld.getDateOfScheduledRepair()))
            return propertyRepairOld.getDateOfScheduledRepair();
        return propertyRepairNew.getDateOfScheduledRepair();
    }


    private String updatePropertyRepairDescription(PropertyRepair propertyRepairOld, PropertyRepair propertyRepairNew) {
        if (propertyRepairNew.getDescription().isEmpty() &&
                propertyRepairNew.getDescription().equals(propertyRepairOld.getDescription()))
            return propertyRepairOld.getDescription();
        return propertyRepairNew.getDescription();
    }

}
