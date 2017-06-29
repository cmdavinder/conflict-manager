package com.hcl.cm.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ENVIRONMENT")
public class Environment {

    @Id
    @GeneratedValue
    @Column(name = "ENVIRONMENT_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ENVIRONMENT_STATUS")
    private String status;
}
