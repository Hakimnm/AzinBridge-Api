package com.programmingtechie.azinbridgeapi.services;

import com.programmingtechie.azinbridgeapi.mapper.ProjectStatusMapper;
import com.programmingtechie.azinbridgeapi.mapper.ServiceMapper;
import com.programmingtechie.azinbridgeapi.models.dto.request.RequestProjectStatus;
import com.programmingtechie.azinbridgeapi.models.dto.request.RequestService;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseProjectStatus;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseService;
import com.programmingtechie.azinbridgeapi.repository.ProjectStatusRepository;
import com.programmingtechie.azinbridgeapi.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicesEntityService {

    private final ServiceRepository serviceRepository;
    private final ServiceMapper mapper;

    public ResponseService create(RequestService request) {
       var result=serviceRepository.save(mapper.toEntity(request));
        return mapper.toResponse(result);
    }

   public ResponseService update(Integer id,RequestService request) {
       var service=serviceRepository.findByIdAndIsActiveTrue(id);
       if(service.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service not found");
       service.get().setName(request.getName());
       service.get().setUrl(request.getUrl());
       service.get().setUrl(request.getApplicationurl());
       service.get().setDescription(request.getDescription());
       return mapper.toResponse(serviceRepository.save(service.get()));
   }
    public List<ResponseService> getAll() {
        return mapper.toResponseList(serviceRepository.findAllByIsActiveTrue());
    }
    public ResponseService findById(Integer id) {
        var response=serviceRepository.findByIdAndIsActiveTrue(id)
                .orElseThrow(() -> new RuntimeException("ProjectStatus not found"));
        return mapper.toResponse(response);
    }

    public boolean deleteById(Integer id) {
        var projectStatus=serviceRepository.findByIdAndIsActiveTrue(id);
        if(projectStatus.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ProjectStatus not found");
        projectStatus.get().setIsActive(false);
        serviceRepository.save(projectStatus.get());
        return true;
    }
}
