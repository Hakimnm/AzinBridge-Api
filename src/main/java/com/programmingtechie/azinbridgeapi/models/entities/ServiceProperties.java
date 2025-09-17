package com.programmingtechie.azinbridgeapi.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "\"ServiceProperties\"", schema = "public")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProperties extends BaseEntity {
    @Column(name = "\"PropertyName\"", nullable = false, length = 200)
    private String propertyName;
}

