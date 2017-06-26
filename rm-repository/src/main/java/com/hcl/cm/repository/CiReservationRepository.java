package com.hcl.cm.repository;


import com.hcl.cm.entities.CiReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CiReservationRepository extends JpaRepository<CiReservation, Long>{
}
