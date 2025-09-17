package com.programmingtechie.azinbridgeapi.mapper;

import com.programmingtechie.azinbridgeapi.models.dto.request.RequestService;
import com.programmingtechie.azinbridgeapi.models.dto.request.RequestServiceProperties;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseService;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseServiceProperties;
import com.programmingtechie.azinbridgeapi.models.entities.ServiceProperties;
import com.programmingtechie.azinbridgeapi.models.entities.Services;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServicePropertiesMapper {
    ServiceProperties toEntity(RequestServiceProperties request);
    ResponseServiceProperties toResponse(ServiceProperties response);
    List<ResponseServiceProperties> toResponseList(List<ServiceProperties> entities);
}
