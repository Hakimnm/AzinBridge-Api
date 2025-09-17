package com.programmingtechie.azinbridgeapi.controller;

import com.programmingtechie.azinbridgeapi.models.dto.response.OrganizationProjectDto;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseOrganizationProject;
import com.programmingtechie.azinbridgeapi.models.entities.OrganizationProject;
import com.programmingtechie.azinbridgeapi.models.entities.ProjectStatus;
import com.programmingtechie.azinbridgeapi.services.ServiceOrganizationProject;
import com.programmingtechie.azinbridgeapi.services.ServicesProjectStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizationProject")
@RequiredArgsConstructor
public class OrganizationProjectController {
    private final ServiceOrganizationProject organizationProject;

    @GetMapping("/getAllList")
    public List<ResponseOrganizationProject> getAllList() {
        return organizationProject.getAll();
    }
    @GetMapping("/getById")
    public ResponseOrganizationProject getById(@RequestParam int id) {
        return organizationProject.getFindById(id);
    }
    @PostMapping("/create")
    public ResponseOrganizationProject save(@RequestBody OrganizationProjectDto request) {
        return organizationProject.create(request);
    }

    @PutMapping("/update")
    public ResponseOrganizationProject updateOrganization(@RequestParam int id,@RequestBody OrganizationProjectDto request) {
        return organizationProject.update(id,request);
    }
    @DeleteMapping("/delete")
    public boolean deleteOrganization(@RequestParam int id) {
        return organizationProject.delete(id);
    }
}
