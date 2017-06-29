package com.hcl.cm.repository;


import com.hcl.cm.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProjectRespository extends JpaRepository<Project, Long>{
}
