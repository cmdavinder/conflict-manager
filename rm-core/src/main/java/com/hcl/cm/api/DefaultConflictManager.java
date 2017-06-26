package com.hcl.cm.api;


import com.hcl.cm.model.CiReservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class DefaultConflictManager implements ConflictManager {

    private static final Function<CiReservation, String> byCompNameAndEnvName = e -> e.getCiName() + ":" + e.getEnvironmentName();

    @Override
    public void findConflicts(List<CiReservation> ciReservations) {

        Map<String, List<CiReservation>> lookupByCompNameAndEnvName = ciReservations.stream()
                                                                              .collect(groupingBy(byCompNameAndEnvName));



        List<CiReservation> conflicts = new ArrayList<>();
        for (CiReservation ciReservation : ciReservations) {
            List<CiReservation> ciReservationsByEnv = lookupByCompNameAndEnvName.get(ciReservation.getCiName() + ":" + ciReservation.getEnvironmentName());
        }


    }

    private void findOverlapAndAddToList(List<CiReservation> reservations) {


    }

}
