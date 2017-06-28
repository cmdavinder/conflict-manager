package com.hcl.cm.api.model;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Conflict {
    private String ciName;
    private String environmentName;
    private String projectName;
    private String releaseCycleName;
    private Date releaseCycleStartDate;
    private Date releaseCycleEndDate;
}
