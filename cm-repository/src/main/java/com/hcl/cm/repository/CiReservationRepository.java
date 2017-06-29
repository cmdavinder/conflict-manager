package com.hcl.cm.repository;


import com.hcl.cm.entities.CiReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CiReservationRepository extends JpaRepository<CiReservation, Long>, JpaSpecificationExecutor<CiReservation>, SearchCiReservationRespository {

}
