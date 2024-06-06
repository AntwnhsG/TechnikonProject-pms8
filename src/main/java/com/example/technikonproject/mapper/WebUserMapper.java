package com.example.technikonproject.mapper;

import com.example.technikonproject.domain.WebUser;
import com.example.technikonproject.transfer.resource.webuser.WebUserResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface WebUserMapper extends BaseMapper<WebUser, WebUserResource>{
}
