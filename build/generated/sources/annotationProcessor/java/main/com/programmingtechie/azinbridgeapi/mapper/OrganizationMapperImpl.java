package com.programmingtechie.azinbridgeapi.mapper;

import com.programmingtechie.azinbridgeapi.models.dto.request.RequestCreateOrganization;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseOrganization;
import com.programmingtechie.azinbridgeapi.models.entities.Organizations;
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
public class OrganizationMapperImpl implements OrganizationMapper {

    @Override
    public Organizations toEntity(RequestCreateOrganization request) {
        if ( request == null ) {
            return null;
        }

        Organizations organizations = new Organizations();

        organizations.setName( request.getName() );
        organizations.setVoen( request.getVoen() );
        organizations.setContactPerson( request.getContactPerson() );

        return organizations;
    }

    @Override
    public ResponseOrganization toResponse(Organizations response) {
        if ( response == null ) {
            return null;
        }

        ResponseOrganization responseOrganization = new ResponseOrganization();

        responseOrganization.setId( response.getId() );
        responseOrganization.setName( response.getName() );
        responseOrganization.setVoen( response.getVoen() );
        responseOrganization.setContactPerson( response.getContactPerson() );

        return responseOrganization;
    }

    @Override
    public List<ResponseOrganization> toResponseList(List<Organizations> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ResponseOrganization> list = new ArrayList<ResponseOrganization>( entities.size() );
        for ( Organizations organizations : entities ) {
            list.add( toResponse( organizations ) );
        }

        return list;
    }
}
