package com.example.technikonproject.controller;

import com.example.technikonproject.domain.PropertyRepair;
import com.example.technikonproject.mapper.BaseMapper;
import com.example.technikonproject.mapper.PropertyRepairMapper;
import com.example.technikonproject.service.BaseService;
import com.example.technikonproject.service.PropertyRepairService;
import com.example.technikonproject.transfer.ApiResponse;
import com.example.technikonproject.dto.PropertyRepairAdminReportResource;
import com.example.technikonproject.transfer.resource.propertyrepair.PropertyRepairResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/propertyRepair")
public class PropertyRepairController extends BaseController<PropertyRepair, PropertyRepairResource> {

    private final PropertyRepairMapper propertyRepairMapper;
    private final PropertyRepairService propertyRepairService;

    @Override
    protected BaseService<PropertyRepair, Long> getBaseService() {
        return propertyRepairService;
    }

    @Override
    protected BaseMapper<PropertyRepair, PropertyRepairResource> getMapper() {
        return propertyRepairMapper;
    }

    @GetMapping(params = "id")
    public ResponseEntity<ApiResponse<List<PropertyRepairResource>>> getPropertyRepairByWebUserId(Long id) {
        return ResponseEntity.ok(
                ApiResponse.<List<PropertyRepairResource>>builder().data(getMapper().toResources(propertyRepairService
                                .findPropertyRepairsByWebUserId(id)))
                        .build());
    }

    @GetMapping(params = {"dateStart", "dateEnd"})
    public ResponseEntity<ApiResponse<List<PropertyRepairResource>>> getPropertyRepairByDate(String dateStart, String dateEnd) {
        LocalDate dateStartConverted = LocalDate.parse(dateStart);
        LocalDate dateEndConverted = LocalDate.parse(dateEnd);
        return ResponseEntity.ok(
                ApiResponse.<List<PropertyRepairResource>>builder().data(getMapper().toResources(propertyRepairService
                                .findPropertyRepairsByRangeOfDates(dateStartConverted, dateEndConverted)))
                        .build());
    }


    @GetMapping(params = {"userId"})
    public ResponseEntity<ApiResponse<List<PropertyRepairAdminReportResource>>> getStatus(Long userId) {
        return ResponseEntity.ok(
                ApiResponse.<List<PropertyRepairAdminReportResource>>builder().data((propertyRepairService.getTotalCost(userId)))
                        .build());
    }

}
