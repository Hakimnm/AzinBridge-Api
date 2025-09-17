package com.programmingtechie.azinbridgeapi.mapper;

import com.programmingtechie.azinbridgeapi.models.dto.request.RequestProjectStatus;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseProjectStatus;
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
public class ProjectStatusMapperImpl implements ProjectStatusMapper {

    @Override
    public ProjectStatus toEntity(RequestProjectStatus request) {
        if ( request == null ) {
            return null;
        }

        ProjectStatus projectStatus = new ProjectStatus();

        projectStatus.setName( request.getName() );
        projectStatus.setDescription( request.getDescription() );

        return projectStatus;
    }

    @Override
    public ResponseProjectStatus toResponse(ProjectStatus response) {
        if ( response == null ) {
            return null;
        }

        ResponseProjectStatus responseProjectStatus = new ResponseProjectStatus();

        responseProjectStatus.setId( response.getId() );
        responseProjectStatus.setName( response.getName() );
        responseProjectStatus.setDescription( response.getDescription() );

        return responseProjectStatus;
    }

    @Override
    public List<ResponseProjectStatus> toResponseList(List<ProjectStatus> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ResponseProjectStatus> list = new ArrayList<ResponseProjectStatus>( entities.size() );
        for ( ProjectStatus projectStatus : entities ) {
            list.add( toResponse( projectStatus ) );
        }

        return list;
    }
}
