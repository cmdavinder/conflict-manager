package com.hcl.cm.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.hcl.cm.api.ConflictManager;
import com.hcl.cm.api.ConflictManagerApiFactory;
import com.hcl.cm.api.model.Conflict;
import com.hcl.cm.api.util.JsonApi;
import com.hcl.cm.entities.CiReservation;
import com.hcl.cm.repository.CiReservationRepository;
import com.hcl.cm.repository.specification.CiReservationSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static com.hcl.cm.repository.specification.CiReservationSpecifications.*;
import static com.hcl.cm.repository.specification.CiReservationSpecifications.byId;
import static java.util.stream.Collectors.toList;

@Service
public class ManageCiReservationsService {
    @Autowired
    CiReservationRepository ciReservationRepository;

    public Collection<Conflict> findConflicts(String filters) {
        try {
            Map<String, String> filtersMap = JsonApi.fromJson(filters, new TypeReference<Map<String, String>>() {
            });
            return findConflicts(filtersMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Collection<Conflict> findConflicts(Map<String, String> filtersMap) {
        if (filtersMap.isEmpty()) {
            return doFindConflicts(ciReservationRepository.findAll());
        } else {
            List<Specification> specifications = filtersMap.entrySet()
                                                           .stream()
                                                           .map(e -> byId(e.getKey(), Long.valueOf(e.getValue())))
                                                           .collect(toList());

            Specifications querySpecs = Specifications.where(specifications.get(0));
            for (int i = 1; i < specifications.size(); i++) {
                querySpecs.and(specifications.get(i));
            }
            return doFindConflicts(ciReservationRepository.findAll(querySpecs));
        }
    }

    private Collection<Conflict> doFindConflicts(Collection<CiReservation> ciReservations) {
        ConflictManager conflictManager = ConflictManagerApiFactory.getInstance().createConflictManager();
        return conflictManager.findConflicts(ciReservations);
    }
}
