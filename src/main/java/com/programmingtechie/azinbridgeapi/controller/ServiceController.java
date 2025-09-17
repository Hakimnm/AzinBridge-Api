package com.programmingtechie.azinbridgeapi.controller;

import com.programmingtechie.azinbridgeapi.models.dto.request.RequestCreateOrganization;
import com.programmingtechie.azinbridgeapi.models.dto.request.RequestService;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseOrganization;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseService;
import com.programmingtechie.azinbridgeapi.services.ServicesEntityService;
import com.programmingtechie.azinbridgeapi.services.ServicesOrganizationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service")
@RequiredArgsConstructor
public class ServiceController {
    private final ServicesEntityService servicesEntityService;

    @GetMapping("/getAll")
    public List<ResponseService> getOrganizations() {
        return servicesEntityService.getAll();
    }
    @GetMapping("/geById")
    public ResponseService getOrganizationsById(@RequestParam int id) {
        return servicesEntityService.findById(id);
    }
    @PostMapping("/create")
    public ResponseService saveOrganization(@RequestBody RequestService request) {
        return servicesEntityService.create(request);
    }

    @PutMapping("/updateOrganization")
    public ResponseService updateOrganization(@RequestParam int id,@RequestBody RequestService request) {
        return servicesEntityService.update(id,request);
    }
    @DeleteMapping("/deleteOrganization")
    public boolean deleteOrganization(@RequestParam int id) {
        return servicesEntityService.deleteById(id);
    }
}
