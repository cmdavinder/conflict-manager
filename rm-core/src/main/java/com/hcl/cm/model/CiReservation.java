package com.hcl.cm.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CiReservation {
    private String ciName;
    private String brc;
    private String qcId;
    private String projectName;
    private String releaseCycleName;
    private Date releaseCycleStartDate;
    private Date releaseCycleEndDate;
    private String environmentName;
    private String usageType;
}
