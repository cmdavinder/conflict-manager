package com.hcl.cm.api;


import com.hcl.cm.model.CiReservation;

import java.util.List;

public interface ConflictManager {

    public void findConflicts(List<CiReservation> ciReservationList);

}
