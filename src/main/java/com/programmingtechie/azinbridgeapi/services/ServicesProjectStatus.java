package com.programmingtechie.azinbridgeapi.services;

import com.programmingtechie.azinbridgeapi.mapper.OrganizationMapper;
import com.programmingtechie.azinbridgeapi.mapper.ProjectStatusMapper;
import com.programmingtechie.azinbridgeapi.models.dto.request.RequestCreateOrganization;
import com.programmingtechie.azinbridgeapi.models.dto.request.RequestProjectStatus;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseProjectStatus;
import com.programmingtechie.azinbridgeapi.models.entities.Organizations;
import com.programmingtechie.azinbridgeapi.models.entities.ProjectStatus;
import com.programmingtechie.azinbridgeapi.repository.OrganizationRepository;
import com.programmingtechie.azinbridgeapi.repository.ProjectStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicesProjectStatus {

    private final ProjectStatusRepository projectStatusRepository;
     private final ProjectStatusMapper mapper;

    public ResponseProjectStatus create(RequestProjectStatus request) {
       var result=projectStatusRepository.save(mapper.toEntity(request));
        return mapper.toResponse(result);
    }

   public ResponseProjectStatus update(Integer id,RequestProjectStatus request) {
       var projectStatus=projectStatusRepository.findByIdAndIsActiveTrue(id);
       if(projectStatus.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ProjectStatus not found");
       projectStatus.get().setName(request.getName());
       projectStatus.get().setDescription(request.getDescription());
       return mapper.toResponse(projectStatusRepository.save(projectStatus.get()));
   }
    public List<ResponseProjectStatus> getAll() {
        return mapper.toResponseList(projectStatusRepository.findAllByIsActiveTrue());
    }
    public ResponseProjectStatus findById(Integer id) {
        var response=projectStatusRepository.findByIdAndIsActiveTrue(id)
                .orElseThrow(() -> new RuntimeException("ProjectStatus not found"));
        return mapper.toResponse(response);
    }

    public boolean deleteById(Integer id) {
        var projectStatus=projectStatusRepository.findByIdAndIsActiveTrue(id);
        if(projectStatus.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ProjectStatus not found");
        projectStatus.get().setIsActive(false);
        projectStatusRepository.save(projectStatus.get());
        return true;
    }
}
