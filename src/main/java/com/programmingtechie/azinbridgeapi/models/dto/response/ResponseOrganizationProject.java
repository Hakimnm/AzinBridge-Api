package com.programmingtechie.azinbridgeapi.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOrganizationProject {
    private Integer id;
    private String name;
    private String description;
    private String authorizationKey;
    private Integer organizationId;
    private Integer projectStatusId;
}
