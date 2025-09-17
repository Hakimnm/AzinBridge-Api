package com.programmingtechie.azinbridgeapi.mapper;

import com.programmingtechie.azinbridgeapi.models.dto.request.RequestCreateOrganization;
import com.programmingtechie.azinbridgeapi.models.dto.request.RequestProjectStatus;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseOrganization;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseProjectStatus;
import com.programmingtechie.azinbridgeapi.models.entities.Organizations;
import com.programmingtechie.azinbridgeapi.models.entities.ProjectStatus;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectStatusMapper {
    ProjectStatus toEntity(RequestProjectStatus request);
    ResponseProjectStatus toResponse(ProjectStatus response);
    List<ResponseProjectStatus> toResponseList(List<ProjectStatus> entities);

}
