package com.hcl.cm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ENVIRONMENT")
public class Environment {

    @Id
    @GeneratedValue
    @Column(name = "ENVIRONMENT_ID")
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ENVIRONMENT_STATUS")
    private String status;
}
