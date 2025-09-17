package com.programmingtechie.azinbridgeapi.mapper;

import com.programmingtechie.azinbridgeapi.models.dto.response.OrganizationProjectDto;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseOrganizationProject;
import com.programmingtechie.azinbridgeapi.models.entities.OrganizationProject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrganizationProjectMapper {

    @Mapping(source = "organizations.id", target = "organizationId")
    @Mapping(source = "projectStatus.id", target = "projectStatusId")
    OrganizationProjectDto toDto(OrganizationProject entity);

    @Mapping(source = "organizations.id", target = "organizationId")
    @Mapping(source = "projectStatus.id", target = "projectStatusId")
    ResponseOrganizationProject toResponse(OrganizationProject dto);

    @Mapping(source = "organizationId", target = "organizations.id")
    @Mapping(source = "projectStatusId", target = "projectStatus.id")
    OrganizationProject toEntity(OrganizationProjectDto dto);


    List<ResponseOrganizationProject> toResponseList(List<OrganizationProject> entities);
}
