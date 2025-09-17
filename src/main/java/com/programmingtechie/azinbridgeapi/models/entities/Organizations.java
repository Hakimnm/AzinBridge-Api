package com.programmingtechie.azinbridgeapi.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "\"Organizations\"", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Organizations extends BaseEntity{
    @Column(name = "\"Name\"", nullable = false, length = 100)
    private String name;
    @Column(name = "\"Voen\"", nullable = false, length = 11)
    private String voen;
    @Column(name =  "\"ContactPerson\"", nullable = false, length = 100)
    private String contactPerson;
}
