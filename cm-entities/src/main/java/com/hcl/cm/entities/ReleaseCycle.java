package com.hcl.cm.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "RELEASE_CYCLE")
public class ReleaseCycle {
    @Id
    @GeneratedValue
    @Column(name = "RELEASE_CYCLE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    @Column(name = "RELEASE_CYCLE_NAME")
    private String name;

    @Column(name = "RELEASE_CYCLE_START_DATE")
    private Date startDate;

    @Column(name = "RELEASE_CYCLE_END_DATE")
    private Date endDate;

    @Column(name = "RELEASE_CYCLE_STATUS")
    private String status;

    @ManyToOne
    @JoinColumn(name = "ENVIRONMENT_ID")
    private Environment environment;
}
