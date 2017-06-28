package com.hcl.cm.service;

import com.hcl.cm.api.ConflictManager;
import com.hcl.cm.api.ConflictManagerFactory;
import com.hcl.cm.api.TestData;
import com.hcl.cm.api.model.Conflict;
import com.hcl.cm.repository.CiReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Collection;

@Service
public class ManageCiReservationsService {
    @Autowired
    CiReservationRepository ciReservationRepository;

    public Collection<Conflict> findConflicts() {
        ConflictManager conflictManager = ConflictManagerFactory.createConflictManager();
        try {
            return conflictManager.findConflicts(
                    //ciReservationRepository.findAll()
                                TestData.getData()
            );
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
