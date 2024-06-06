package com.example.technikonproject.controller;

import com.example.technikonproject.domain.Property;
import com.example.technikonproject.mapper.BaseMapper;
import com.example.technikonproject.mapper.PropertyMapper;
import com.example.technikonproject.service.BaseService;
import com.example.technikonproject.service.PropertyService;
import com.example.technikonproject.transfer.ApiResponse;
import com.example.technikonproject.transfer.resource.property.PropertyResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/property")
public class PropertyController extends BaseController<Property, PropertyResource> {

    private final PropertyMapper propertyMapper;
    private final PropertyService propertyService;

    @Override
    protected BaseService<Property, Long> getBaseService() {
        return propertyService;
    }

    @Override
    protected BaseMapper<Property, PropertyResource> getMapper() {
        return propertyMapper;
    }

    @GetMapping(params = {"tin"})
    public ResponseEntity<ApiResponse<List<PropertyResource>>> findByTin(@RequestParam Long tin) {
        return ResponseEntity.ok(
                ApiResponse.<List<PropertyResource>>builder().data(getMapper().toResources(propertyService.findPropertiesByTin(tin)))
                        .build());
    }

    @GetMapping(params = {"e9"})
    public ResponseEntity<ApiResponse<PropertyResource>> findByE9(@RequestParam Long e9) {
        return ResponseEntity.ok(
                ApiResponse.<PropertyResource>builder().data(getMapper().toResource(propertyService.readProperty(e9)))
                        .build());
    }

    @GetMapping("count")
    public ResponseEntity<ApiResponse<Long>> countAllUsers() {
        return ResponseEntity.ok(
                ApiResponse.<Long>builder().data((propertyService.count()))
                        .build());
    }
}
