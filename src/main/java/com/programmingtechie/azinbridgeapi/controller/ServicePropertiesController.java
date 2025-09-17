package com.programmingtechie.azinbridgeapi.controller;

import com.programmingtechie.azinbridgeapi.models.dto.request.RequestService;
import com.programmingtechie.azinbridgeapi.models.dto.request.RequestServiceProperties;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseService;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseServiceProperties;
import com.programmingtechie.azinbridgeapi.services.ServicesProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/serviceProperties")
@RequiredArgsConstructor
public class ServicePropertiesController {
    private final ServicesProperties serviceProperties;

    @GetMapping("/getAll")
    public List<ResponseServiceProperties> getAllList() {
        return serviceProperties.getAll();
    }
    @GetMapping("/getById")
    public ResponseServiceProperties getById(@RequestParam int id) {
        return serviceProperties.findById(id);
    }
    @PostMapping("/create")
    public ResponseServiceProperties save(@RequestBody RequestServiceProperties request) {
        return serviceProperties.create(request);
    }

    @PutMapping("/update")
    public ResponseServiceProperties update(@RequestParam int id,@RequestBody RequestServiceProperties request) {
        return serviceProperties.update(id,request);
    }
    @DeleteMapping("/delete")
    public boolean deleteOrganization(@RequestParam int id) {
        return serviceProperties.deleteById(id);
    }
}
