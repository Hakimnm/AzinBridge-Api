package com.programmingtechie.azinbridgeapi.services;

import com.programmingtechie.azinbridgeapi.mapper.OrganizationProjectMapper;
import com.programmingtechie.azinbridgeapi.models.dto.response.OrganizationProjectDto;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseOrganizationProject;
import com.programmingtechie.azinbridgeapi.models.entities.OrganizationProject;
import com.programmingtechie.azinbridgeapi.repository.OrganizationProjectRepository;
import com.programmingtechie.azinbridgeapi.repository.OrganizationRepository;
import com.programmingtechie.azinbridgeapi.repository.ProjectStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceOrganizationProject {
    private final OrganizationProjectRepository organizationProjectRepository;
    private final OrganizationRepository organizationRepository;
    private final ProjectStatusRepository projectStatusRepository;
    private final OrganizationProjectMapper mapper;

    public ResponseOrganizationProject create(OrganizationProjectDto input) {
        var entity=mapper.toEntity(input);
        var result= organizationProjectRepository.save(entity);
        return mapper.toResponse(result);
    }

    public ResponseOrganizationProject update(Integer id, OrganizationProjectDto input) {
        var organizationProject =organizationProjectRepository.findByIdAndIsActiveTrue(id);
        if(organizationProject.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Organization not found");

        organizationProject.get().setName(input.getName());
        organizationProject.get().setAuthorizationKey(input.getAuthorizationKey());
        organizationProject.get().setDescription(input.getDescription());

        if(input.getOrganizationId()!=null && input.getOrganizationId()>0) {
            var org = organizationRepository.findByIdAndIsActiveTrue(input.getOrganizationId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organization id not found"));
            organizationProject.get().setOrganizations(org);
        }
        if(input.getProjectStatusId()!=null && input.getProjectStatusId()>0) {
            var prjs = projectStatusRepository.findByIdAndIsActiveTrue(input.getProjectStatusId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ProjectStatus id not found"));
            organizationProject.get().setProjectStatus(prjs);
        }

      var result= organizationProjectRepository.save(organizationProject.get());
        return mapper.toResponse(result);
    }

    public List<ResponseOrganizationProject> getAll() {
                   var entities = organizationProjectRepository.findAllByIsActiveTrue();
            return mapper.toResponseList(entities);
    }
    public ResponseOrganizationProject getFindById(Integer id) {
        var entity= organizationProjectRepository.findByIdAndIsActiveTrue(id)
                .orElseThrow(() -> new RuntimeException("OrganizationProject not found"));
        return mapper.toResponse(entity);
    }
    public boolean delete(Integer id) {
        var organizationProject=organizationProjectRepository.findByIdAndIsActiveTrue(id);
        if(organizationProject.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "OrganizationProject id not found");
        organizationProject.get().setIsActive(false);
        organizationProjectRepository.save(organizationProject.get());
        return true;
    }
}
