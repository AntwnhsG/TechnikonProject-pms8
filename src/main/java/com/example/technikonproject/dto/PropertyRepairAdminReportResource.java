package com.example.technikonproject.dto;

import com.example.technikonproject.domain.enums.RepairStatus;
import com.example.technikonproject.domain.enums.RepairType;
import com.example.technikonproject.transfer.resource.BaseResource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PropertyRepairAdminReportResource {

    private RepairType repairType;

    private RepairStatus repairStatus;

    private BigDecimal costOfRepair;

    public PropertyRepairAdminReportResource(RepairType repairType, RepairStatus repairStatus, BigDecimal costOfRepair) {
        this.repairType = repairType;
        this.repairStatus = repairStatus;
        this.costOfRepair = costOfRepair;
    }

}
