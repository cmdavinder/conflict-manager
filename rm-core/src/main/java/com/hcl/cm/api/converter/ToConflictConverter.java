package com.hcl.cm.api.converter;


import com.hcl.cm.api.model.Conflict;
import com.hcl.cm.entities.CiReservation;

public class ToConflictConverter {

    public static Conflict from(CiReservation reservation) {
        return Conflict.builder()
                       .environmentName(reservation.getEnvironment().getName())
                       .ciName(reservation.getCi().getName())
                       .projectName(reservation.getProject().getProjectName())
                       .releaseCycleName(reservation.getReleaseCycle().getName())
                       .releaseCycleStartDate(reservation.getReleaseCycle().getStartDate())
                       .releaseCycleEndDate(reservation.getReleaseCycle().getEndDate())
                       .build();
    }
}
