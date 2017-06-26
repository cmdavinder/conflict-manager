package com.hcl.cm.repository;


import com.hcl.cm.entities.Environment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EnvironmentRepository extends JpaRepository<Environment, Long> {
}
