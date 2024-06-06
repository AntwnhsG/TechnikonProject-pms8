package com.example.technikonproject.service;

import com.example.technikonproject.domain.Property;

import java.util.List;

public interface PropertyService extends BaseService<Property, Long> {

    List<Property> findPropertiesByTin(Long tin);

    Property update(Property property);

    Property readProperty(Long e9Number);
}
