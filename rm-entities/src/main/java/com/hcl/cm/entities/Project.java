package com.hcl.cm.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PROJECT")
public class Project {
    @Id
    @GeneratedValue
    @Column(name = "PROJECT_ID")
    private Long id;

    @Column(name = "NAME")
    private String projectName;

    @Column(name = "PROJECT_START_DATE")
    private Date startDate;

    @Column(name = "PROJECT_END_DATE")
    private Date endDate;

    @Column(name="PROJECT_STATUS")
    private String status;

    @Column(name="CREATED_ON")
    private Date createdOn;
}
