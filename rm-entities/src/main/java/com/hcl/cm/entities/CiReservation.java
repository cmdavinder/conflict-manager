package com.hcl.cm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CI_RESERVATION")
public class CiReservation {

    @Id
    @GeneratedValue
    @Column(name = "CI_RESERVATION_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "RELEASE_CYCLE_ID")
    private ReleaseCycle releaseCycle;

    @ManyToOne
    @JoinColumn(name = "ENVIRONMENT_ID")
    private Environment environment;

    @Column(name = "CI_RESERVATION_STATUS")
    private String status;

    @Column(name = "REMARKS")
    private String remarks;
}