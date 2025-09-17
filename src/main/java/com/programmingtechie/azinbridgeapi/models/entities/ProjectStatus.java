package com.programmingtechie.azinbridgeapi.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "\"ProjectStatuses\"", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProjectStatus extends BaseEntity {

    @Column(name = "\"Name\"", nullable = false, length = 100)
    private String name;
    @Column(name = "\"Description\"", nullable = false, length = 200)
    private String description;
}

