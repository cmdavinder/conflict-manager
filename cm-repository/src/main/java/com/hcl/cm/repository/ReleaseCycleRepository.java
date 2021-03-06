package com.hcl.cm.repository;


import com.hcl.cm.entities.ReleaseCycle;
import com.hcl.cm.repository.projection.ReleaseCycleProjectExcerpt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = ReleaseCycleProjectExcerpt.class)
public interface ReleaseCycleRepository extends JpaRepository<ReleaseCycle, Long> {
    List<ReleaseCycle> findByProjectId(@Param("projectId") Long projectId);
}
