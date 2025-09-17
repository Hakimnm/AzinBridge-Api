package com.programmingtechie.azinbridgeapi.controller;

import com.programmingtechie.azinbridgeapi.models.dto.request.RequestCreateOrganization;
import com.programmingtechie.azinbridgeapi.models.dto.response.ResponseOrganization;
import com.programmingtechie.azinbridgeapi.models.entities.Organizations;
import com.programmingtechie.azinbridgeapi.services.ServicesOrganizationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organization")
@RequiredArgsConstructor
public class OrganizationController {
    private final ServicesOrganizationEntity organizationEntity;

    @GetMapping("/getAll")
    public List<ResponseOrganization> getAll() {
        return organizationEntity.getAllOrganization();
    }
    @GetMapping("/getById")
    public ResponseOrganization getById(@RequestParam int id) {
        return organizationEntity.findById(id);
    }
    @PostMapping("/createOrganization")
    public ResponseOrganization save(@RequestBody RequestCreateOrganization organization) {
        return organizationEntity.create(organization);
    }

    @PutMapping("/update")
    public ResponseOrganization update(@RequestParam int id,@RequestBody RequestCreateOrganization organization) {
        return organizationEntity.update(id,organization);
    }
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam int id) {
        return organizationEntity.deleteById(id);
    }
}
