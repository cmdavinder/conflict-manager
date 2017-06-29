package com.hcl.cm.repository;


import com.hcl.cm.entities.ReleaseCycle;
import com.hcl.cm.repository.projection.ReleaseCycleProjectExcerpt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = ReleaseCycleProjectExcerpt.class)
public interface ReleaseCycleRepository extends JpaRepository<ReleaseCycle, Long> {
}
