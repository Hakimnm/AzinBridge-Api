package com.programmingtechie.azinbridgeapi.models.dto.request;

import jakarta.persistence.Column;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateOrganization {
    private String name;
    private String voen;
    private String contactPerson;
}
