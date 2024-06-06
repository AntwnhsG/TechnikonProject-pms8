package com.example.technikonproject.service;

import com.example.technikonproject.domain.PropertyRepair;
import com.example.technikonproject.dto.PropertyRepairAdminReportResource;

import java.time.LocalDate;
import java.util.List;

public interface PropertyRepairService extends BaseService<PropertyRepair, Long> {


    List<PropertyRepair> findPropertyRepairsByRangeOfDates(LocalDate dateStart, LocalDate dateEnd);

    List<PropertyRepair> findPropertyRepairsByWebUserId(Long tin);

    void updatePropertyRepair(PropertyRepair propertyRepair);

    PropertyRepair findPropertyRepair(Long id);

    List<PropertyRepairAdminReportResource> getTotalCost(Long userId);
}