package com.hcl.cm.repository.projection;


import com.hcl.cm.entities.Environment;
import com.hcl.cm.entities.Project;
import com.hcl.cm.entities.ReleaseCycle;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "project", types = {ReleaseCycle.class})
public interface ReleaseCycleProjectExcerpt {
    String getName();

    Date getStartDate();

    Date getEndDate();

    String getStatus();

    Project getProject();

    Environment getEnvironment();
}
