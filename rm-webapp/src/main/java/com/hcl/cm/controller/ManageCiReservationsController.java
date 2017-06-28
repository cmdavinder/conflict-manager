package com.hcl.cm.controller;


import com.hcl.cm.api.model.Conflict;
import com.hcl.cm.service.ManageCiReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ManageCiReservationsController {

    @Autowired
    private ManageCiReservationsService manageCiReservationsService;

    @GetMapping("/generateConflicts")
    public Collection<Conflict> generateConflicts(){
        return manageCiReservationsService.findConflicts();
    }
}
