package com.example.technikonproject.transfer.resource.propertyrepair;

import com.example.technikonproject.domain.enums.RepairStatus;
import com.example.technikonproject.domain.enums.RepairType;
import com.example.technikonproject.transfer.resource.BaseResource;
import com.example.technikonproject.transfer.resource.property.PropertyMedInfoResource;
import com.example.technikonproject.transfer.resource.webuser.WebUserMedInfoResource;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PropertyRepairResource extends BaseResource {

    private WebUserMedInfoResource webUser;

    private PropertyMedInfoResource property;

    private String description;

    private LocalDate dateOfScheduledRepair;

    private RepairType repairType;

    private RepairStatus repairStatus;

    private BigDecimal costOfRepair;


}
