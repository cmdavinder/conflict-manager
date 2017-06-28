package com.hcl.cm.repository.projection;


import com.hcl.cm.entities.ReleaseCycle;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "project", types = {ReleaseCycle.class})
public interface ReleaseCycleProjectProjection {
   String getProjectName();
}
