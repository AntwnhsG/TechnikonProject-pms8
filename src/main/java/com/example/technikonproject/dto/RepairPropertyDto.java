package com.example.technikonproject.dto;

import com.example.technikonproject.domain.Property;
import com.example.technikonproject.domain.WebUser;
import com.example.technikonproject.domain.enums.RepairStatus;
import com.example.technikonproject.domain.enums.RepairType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RepairPropertyDto {

    private WebUser WebUser;

    private Property propertyE9;

    private LocalDate dateOfScheduledRepair;

    private String description;

    private BigDecimal costOfRepair;

    private RepairType repairType;

    private RepairStatus repairStatus;

}
