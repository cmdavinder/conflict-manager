package com.hcl.cm.repository;


import com.hcl.cm.entities.CiReservation;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchCiReservationRespository {

    List<CiReservation> findByProjectId(@Param("projectId") Long projectId);

    List<CiReservation> findByCiId(@Param("ciId") Long ciId);

    List<CiReservation> findByProjectIdAndCiId(@Param("projectId") Long projectId, @Param("ciId") Long ciId);

    List<CiReservation> findByProjectIdAndReleaseCycleId(@Param("projectId") Long projectId, @Param("releaseCycleId") Long releaseCycleId);

    List<CiReservation> findByReleaseCycleIdAndCiId(@Param("releaseCycleId") Long releaseCycleId, @Param("ciId") Long ciId);

    List<CiReservation> findByProjectIdAndCiIdAndReleaseCycleId(@Param("projectId") Long projectId, @Param("ciId") Long ciId, @Param("releaseCycleId") String releaseCycleId);

}
