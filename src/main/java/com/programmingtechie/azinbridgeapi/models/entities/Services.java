package com.programmingtechie.azinbridgeapi.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "\"Services\"", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Services extends BaseEntity{
    @Column( name = "\"Name\"",length = 50, nullable = false)
    private String name;

    @Column( name = "\"Description\"",length = 200)
    private String description;

    @Column(name = "\"Url\"",length = 200, nullable = false)
    private String url;

    @Column( name = "\"ApplicationUrl\"",length = 200, nullable = false)
    private String applicationurl;
}
