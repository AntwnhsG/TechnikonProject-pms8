package com.example.technikonproject.mapper;

import com.example.technikonproject.domain.PropertyRepair;
import com.example.technikonproject.transfer.resource.propertyrepair.PropertyRepairResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {PropertyMedInfoMapper.class, WebUserMedInfoMapper.class}, config = IgnoreUnmappedMapperConfig.class)
public interface PropertyRepairMapper extends BaseMapper<PropertyRepair, PropertyRepairResource> {
}
