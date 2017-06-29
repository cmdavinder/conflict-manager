package com.hcl.cm.api;

import com.hcl.cm.api.model.Conflict;
import com.hcl.cm.entities.CiReservation;

import java.util.Collection;
import java.util.List;

public interface ConflictManager {

    public abstract Collection<Conflict> findConflicts(Collection<CiReservation> ciReservations);

    public abstract void mitigateConflicts();
}
