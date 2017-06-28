package com.hcl.cm.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CONFIGURATION_ITEM")
public class ConfigurationItem {

    @Id
    @GeneratedValue
    @Column(name = "CI_ID")
    private Long id;

    @Column(name = "CI_NAME")
    private String name;

    @Column(name = "CI_DESCRIPTION")
    private String description;
}
