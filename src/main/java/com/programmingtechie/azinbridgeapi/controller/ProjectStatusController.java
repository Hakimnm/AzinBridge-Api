package com.programmingtechie.azinbridgeapi.controller;

import com.programmingtechie.azinbridgeapi.models.dto.request.RequestCreateOrganization;
import com.programmingtechie.azinbridgeapi.models.dto.request.RequestProjectStatus;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseProjectStatus;
import com.programmingtechie.azinbridgeapi.models.entities.Organizations;
import com.programmingtechie.azinbridgeapi.models.entities.ProjectStatus;
import com.programmingtechie.azinbridgeapi.services.ServicesOrganizationEntity;
import com.programmingtechie.azinbridgeapi.services.ServicesProjectStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projectStatus")
@RequiredArgsConstructor
public class ProjectStatusController {
    private final ServicesProjectStatus projectStatus;

    @GetMapping("/getAllList")
    public List<ResponseProjectStatus> getAllList() {
        return projectStatus.getAll();
    }
    @GetMapping("/getById")
    public ResponseProjectStatus getById(@RequestParam int id) {
        return projectStatus.findById(id);
    }
    @PostMapping("/create")
    public ResponseProjectStatus save(@RequestBody RequestProjectStatus request) {
        return projectStatus.create(request);
    }

    @PutMapping("/update")
    public ResponseProjectStatus updateOrganization(@RequestParam int id,@RequestBody RequestProjectStatus request) {
        return projectStatus.update(id,request);
    }
    @DeleteMapping("/delete")
    public boolean deleteOrganization(@RequestParam int id) {
        return projectStatus.deleteById(id);
    }
}
