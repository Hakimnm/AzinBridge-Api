package com.programmingtechie.azinbridgeapi.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "\"OrganizationProjects\"", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrganizationProject extends BaseEntity{

    @Column(name = "\"Name\"", nullable = false)
    private String name;
    @Column(name = "\"Description\"", nullable = false)
    private String description;
    @Column(name = "\"AuthorizationKey\"", nullable = false)
    private String authorizationKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"OrganizationId\"", nullable = false)
    private Organizations organizations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"ProjectStatusId\"", nullable = false)
    private ProjectStatus projectStatus;
}
