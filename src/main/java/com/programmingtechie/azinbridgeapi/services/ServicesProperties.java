package com.programmingtechie.azinbridgeapi.services;

import com.programmingtechie.azinbridgeapi.mapper.ProjectStatusMapper;
import com.programmingtechie.azinbridgeapi.mapper.ServicePropertiesMapper;
import com.programmingtechie.azinbridgeapi.models.dto.request.RequestProjectStatus;
import com.programmingtechie.azinbridgeapi.models.dto.request.RequestServiceProperties;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseProjectStatus;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseServiceProperties;
import com.programmingtechie.azinbridgeapi.repository.ProjectStatusRepository;
import com.programmingtechie.azinbridgeapi.repository.ServicePropertiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicesProperties {

    private final ServicePropertiesRepository servicePropertiesRepository;
     private final ServicePropertiesMapper mapper;

    public ResponseServiceProperties create(RequestServiceProperties request) {
       var result=servicePropertiesRepository.save(mapper.toEntity(request));
        return mapper.toResponse(result);
    }

   public ResponseServiceProperties update(Integer id, RequestServiceProperties request) {
       var property=servicePropertiesRepository.findByIdAndIsActiveTrue(id);
       if(property.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ServiceProperty is not found");
       property.get().setPropertyName(request.getPropertyName());
       return mapper.toResponse(servicePropertiesRepository.save(property.get()));
   }
    public List<ResponseServiceProperties> getAll() {
        return mapper.toResponseList(servicePropertiesRepository.findAllByIsActiveTrue());
    }
    public ResponseServiceProperties findById(Integer id) {
        var response=servicePropertiesRepository.findByIdAndIsActiveTrue(id)
                .orElseThrow(() -> new RuntimeException("ServiceProperty is not found"));
        return mapper.toResponse(response);
    }

    public boolean deleteById(Integer id) {
        var property=servicePropertiesRepository.findByIdAndIsActiveTrue(id);
        if(property.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ServiceProperty is not found");
        property.get().setIsActive(false);
        servicePropertiesRepository.save(property.get());
        return true;
    }
}
