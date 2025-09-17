package com.programmingtechie.azinbridgeapi.models.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestProjectStatus {
    private String name;
    private String description;
}
