package com.programmingtechie.azinbridgeapi.services;

import com.programmingtechie.azinbridgeapi.mapper.OrganizationMapper;
import com.programmingtechie.azinbridgeapi.models.dto.request.RequestCreateOrganization;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseOrganization;
import com.programmingtechie.azinbridgeapi.models.entities.Organizations;
import com.programmingtechie.azinbridgeapi.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicesOrganizationEntity {

    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;


    public ResponseOrganization create(RequestCreateOrganization requestOrganization) {
       var organizations= organizationMapper.toEntity(requestOrganization);
        return organizationMapper.toResponse(organizationRepository.save(organizations));
    }
   public ResponseOrganization update(Integer id,RequestCreateOrganization input) {
       var organization=organizationRepository.findByIdAndIsActiveTrue(id);
       if(organization.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Organization not found");
       organization.get().setName(input.getName());
       organization.get().setVoen(input.getVoen());
       organization.get().setContactPerson(input.getContactPerson());
       return organizationMapper.toResponse(organizationRepository.save(organization.get()));
   }
    public List<ResponseOrganization> getAllOrganization() {
        return organizationMapper.toResponseList(organizationRepository.findAllByIsActiveTrue());
    }
    public ResponseOrganization findById(Integer id) {
        var response= organizationRepository.findByIdAndIsActiveTrue(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        return organizationMapper.toResponse(response);
    }

    public boolean deleteById(Integer id) {
        var organization=organizationRepository.findByIdAndIsActiveTrue(id);
        if(organization.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Organization not found");
        organization.get().setIsActive(false);
        organizationRepository.save(organization.get());
        return true;
    }
}
