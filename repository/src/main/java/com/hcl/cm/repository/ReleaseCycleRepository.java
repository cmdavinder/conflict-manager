package com.hcl.cm.repository;


import com.hcl.cm.entities.ReleaseCycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReleaseCycleRepository extends JpaRepository<ReleaseCycle, Long> {
}
