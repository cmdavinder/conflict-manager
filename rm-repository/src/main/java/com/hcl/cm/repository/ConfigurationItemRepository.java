package com.hcl.cm.repository;


import com.hcl.cm.entities.ConfigurationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ConfigurationItemRepository extends JpaRepository<ConfigurationItem, Long>{
}
