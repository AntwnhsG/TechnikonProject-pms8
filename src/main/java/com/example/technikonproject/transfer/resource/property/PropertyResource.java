package com.example.technikonproject.transfer.resource.property;

import com.example.technikonproject.domain.enums.PropertyType;
import com.example.technikonproject.domain.subDomain.Address;
import com.example.technikonproject.transfer.resource.BaseResource;
import com.example.technikonproject.transfer.resource.webuser.WebUserResource;
import lombok.Data;

import java.util.Date;

@Data
public class PropertyResource extends BaseResource {

    private Long e9Number;

    private Address address;

    private WebUserResource webUser;

    private Date yearOfConstruction;

    private PropertyType propertyType;

    private String picture;

    private String location;
}
