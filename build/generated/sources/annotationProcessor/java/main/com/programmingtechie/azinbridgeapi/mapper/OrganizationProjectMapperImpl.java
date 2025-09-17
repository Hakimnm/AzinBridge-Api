package com.programmingtechie.azinbridgeapi.mapper;

import com.programmingtechie.azinbridgeapi.models.dto.response.OrganizationProjectDto;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseOrganizationProject;
import com.programmingtechie.azinbridgeapi.models.entities.OrganizationProject;
import com.programmingtechie.azinbridgeapi.models.entities.Organizations;
import com.programmingtechie.azinbridgeapi.models.entities.ProjectStatus;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-17T17:31:28+0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class OrganizationProjectMapperImpl implements OrganizationProjectMapper {

    @Override
    public OrganizationProjectDto toDto(OrganizationProject entity) {
        if ( entity == null ) {
            return null;
        }

        OrganizationProjectDto organizationProjectDto = new OrganizationProjectDto();

        organizationProjectDto.setOrganizationId( entityOrganizationsId( entity ) );
        organizationProjectDto.setProjectStatusId( entityProjectStatusId( entity ) );
        organizationProjectDto.setName( entity.getName() );
        organizationProjectDto.setDescription( entity.getDescription() );
        organizationProjectDto.setAuthorizationKey( entity.getAuthorizationKey() );

        return organizationProjectDto;
    }

    @Override
    public ResponseOrganizationProject toResponse(OrganizationProject dto) {
        if ( dto == null ) {
            return null;
        }

        ResponseOrganizationProject responseOrganizationProject = new ResponseOrganizationProject();

        responseOrganizationProject.setOrganizationId( entityOrganizationsId( dto ) );
        responseOrganizationProject.setProjectStatusId( entityProjectStatusId( dto ) );
        responseOrganizationProject.setId( dto.getId() );
        responseOrganizationProject.setName( dto.getName() );
        responseOrganizationProject.setDescription( dto.getDescription() );
        responseOrganizationProject.setAuthorizationKey( dto.getAuthorizationKey() );

        return responseOrganizationProject;
    }

    @Override
    public OrganizationProject toEntity(OrganizationProjectDto dto) {
        if ( dto == null ) {
            return null;
        }

        OrganizationProject organizationProject = new OrganizationProject();

        organizationProject.setOrganizations( organizationProjectDtoToOrganizations( dto ) );
        organizationProject.setProjectStatus( organizationProjectDtoToProjectStatus( dto ) );
        organizationProject.setName( dto.getName() );
        organizationProject.setDescription( dto.getDescription() );
        organizationProject.setAuthorizationKey( dto.getAuthorizationKey() );

        return organizationProject;
    }

    @Override
    public List<ResponseOrganizationProject> toResponseList(List<OrganizationProject> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ResponseOrganizationProject> list = new ArrayList<ResponseOrganizationProject>( entities.size() );
        for ( OrganizationProject organizationProject : entities ) {
            list.add( toResponse( organizationProject ) );
        }

        return list;
    }

    private Integer entityOrganizationsId(OrganizationProject organizationProject) {
        if ( organizationProject == null ) {
            return null;
        }
        Organizations organizations = organizationProject.getOrganizations();
        if ( organizations == null ) {
            return null;
        }
        Integer id = organizations.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer entityProjectStatusId(OrganizationProject organizationProject) {
        if ( organizationProject == null ) {
            return null;
        }
        ProjectStatus projectStatus = organizationProject.getProjectStatus();
        if ( projectStatus == null ) {
            return null;
        }
        Integer id = projectStatus.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Organizations organizationProjectDtoToOrganizations(OrganizationProjectDto organizationProjectDto) {
        if ( organizationProjectDto == null ) {
            return null;
        }

        Organizations organizations = new Organizations();

        organizations.setId( organizationProjectDto.getOrganizationId() );

        return organizations;
    }

    protected ProjectStatus organizationProjectDtoToProjectStatus(OrganizationProjectDto organizationProjectDto) {
        if ( organizationProjectDto == null ) {
            return null;
        }

        ProjectStatus projectStatus = new ProjectStatus();

        projectStatus.setId( organizationProjectDto.getProjectStatusId() );

        return projectStatus;
    }
}
