package com.programmingtechie.azinbridgeapi.models.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Id\"")
    private Integer id;
    @CreationTimestamp
    @Column(name = "\"CreatedDate\"",updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "\"IsActive\"")
    @Builder.Default
    private Boolean isActive=true;
}
