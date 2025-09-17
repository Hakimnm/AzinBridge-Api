package com.programmingtechie.azinbridgeapi.mapper;

import com.programmingtechie.azinbridgeapi.models.dto.request.RequestService;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseService;
import com.programmingtechie.azinbridgeapi.models.entities.Services;
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
public class ServiceMapperImpl implements ServiceMapper {

    @Override
    public Services toEntity(RequestService request) {
        if ( request == null ) {
            return null;
        }

        Services.ServicesBuilder services = Services.builder();

        services.name( request.getName() );
        services.description( request.getDescription() );
        services.url( request.getUrl() );
        services.applicationurl( request.getApplicationurl() );

        return services.build();
    }

    @Override
    public ResponseService toResponse(Services response) {
        if ( response == null ) {
            return null;
        }

        ResponseService responseService = new ResponseService();

        responseService.setId( response.getId() );
        responseService.setName( response.getName() );
        responseService.setDescription( response.getDescription() );
        responseService.setUrl( response.getUrl() );
        responseService.setApplicationurl( response.getApplicationurl() );

        return responseService;
    }

    @Override
    public List<ResponseService> toResponseList(List<Services> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ResponseService> list = new ArrayList<ResponseService>( entities.size() );
        for ( Services services : entities ) {
            list.add( toResponse( services ) );
        }

        return list;
    }
}
