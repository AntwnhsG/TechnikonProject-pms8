package com.example.technikonproject.transfer.resource.property;

import com.example.technikonproject.domain.enums.PropertyType;
import com.example.technikonproject.transfer.resource.BaseResource;
import lombok.Data;

@Data
public class PropertyMedInfoResource extends BaseResource {

    private PropertyType propertyType;

}
