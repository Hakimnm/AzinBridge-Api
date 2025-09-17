package com.programmingtechie.azinbridgeapi.mapper;

import com.programmingtechie.azinbridgeapi.models.dto.request.RequestServiceProperties;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseServiceProperties;
import com.programmingtechie.azinbridgeapi.models.entities.ServiceProperties;
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
public class ServicePropertiesMapperImpl implements ServicePropertiesMapper {

    @Override
    public ServiceProperties toEntity(RequestServiceProperties request) {
        if ( request == null ) {
            return null;
        }

        ServiceProperties serviceProperties = new ServiceProperties();

        serviceProperties.setPropertyName( request.getPropertyName() );

        return serviceProperties;
    }

    @Override
    public ResponseServiceProperties toResponse(ServiceProperties response) {
        if ( response == null ) {
            return null;
        }

        ResponseServiceProperties responseServiceProperties = new ResponseServiceProperties();

        responseServiceProperties.setId( response.getId() );
        responseServiceProperties.setPropertyName( response.getPropertyName() );

        return responseServiceProperties;
    }

    @Override
    public List<ResponseServiceProperties> toResponseList(List<ServiceProperties> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ResponseServiceProperties> list = new ArrayList<ResponseServiceProperties>( entities.size() );
        for ( ServiceProperties serviceProperties : entities ) {
            list.add( toResponse( serviceProperties ) );
        }

        return list;
    }
}
