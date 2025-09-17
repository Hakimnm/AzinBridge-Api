package com.programmingtechie.azinbridgeapi.mapper;

import com.programmingtechie.azinbridgeapi.models.dto.request.RequestCreateOrganization;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseOrganization;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseOrganizationProject;
import com.programmingtechie.azinbridgeapi.models.entities.OrganizationProject;
import com.programmingtechie.azinbridgeapi.models.entities.Organizations;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {
    //RequestCreateOrganization toDto(Organizations organizations);
    Organizations toEntity(RequestCreateOrganization request);
     ResponseOrganization toResponse(Organizations response);

    List<ResponseOrganization> toResponseList(List<Organizations> entities);

}
