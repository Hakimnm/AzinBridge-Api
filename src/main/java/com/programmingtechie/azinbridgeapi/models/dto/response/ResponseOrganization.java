package com.programmingtechie.azinbridgeapi.models.dto.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOrganization {
    private Integer id;
    private String name;
    private String voen;
    private String contactPerson;
}
