package com.programmingtechie.azinbridgeapi.models.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestService {
    private String name;
    private String description;
    private String url;
    private String applicationurl;
}
