package com.hcl.cm.api;


import com.hcl.cm.api.converter.ConvertToConflict;
import com.hcl.cm.api.model.Conflict;
import com.hcl.cm.entities.CiReservation;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class DefaultConflictManager implements ConflictManager {

    @Override
    public Collection<Conflict> findConflicts(List<CiReservation> reservations) {
        Collection<Conflict> conflicts = new HashSet<>();
        Map<String, List<CiReservation>> lookupByEnv = reservations.stream()
                                                                   .collect(groupingBy(e -> e.getEnvironment().getName()));
        for (String envName : lookupByEnv.keySet()) {
            List<CiReservation> reservationsForEnv = lookupByEnv.get(envName);
            int reservationsForEnvCount = reservationsForEnv.size();
            for (int i = 0; i < reservationsForEnvCount; i++) {
                for (int j = i + 1; j < reservationsForEnvCount; j++) {
                    CiReservation reservation1 = reservationsForEnv.get(i);
                    CiReservation reservation2 = reservationsForEnv.get(j);

                    Long CiId1 = reservation1.getCi().getId();
                    Long CiId2 = reservation2.getCi().getId();
                    if (!Objects.equals(CiId1, CiId2)) {
                        continue;
                    }
                    if (isReleaseCyclesOverlap(reservation1, reservation2)) {
                        Conflict conflict1 = ConvertToConflict.from(reservation1);
                        Conflict conflict2 = ConvertToConflict.from(reservation2);

                        conflicts.add(conflict1);
                        conflicts.add(conflict2);
                    }
                }
            }
        }
        return conflicts;
    }

    @Override
    public void mitigateConflicts() {

    }

    private boolean isReleaseCyclesOverlap(CiReservation reservation1, CiReservation reservation2) {
        Date startDate1 = reservation1.getReleaseCycle().getStartDate();
        Date endDate1 = reservation1.getReleaseCycle().getEndDate();
        Date startDate2 = reservation2.getReleaseCycle().getStartDate();
        Date endDate2 = reservation2.getReleaseCycle().getEndDate();
        return (startDate1.getTime() <= endDate2.getTime()) && (endDate1.getTime() >= startDate2.getTime());
    }
}
