package com.hcl.cm.controller;


import com.hcl.cm.entities.ReleaseCycle;
import com.hcl.cm.service.ManageReleaseCyclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManageReleaseCyclesController {


    @Autowired
    ManageReleaseCyclesService manageReleaseCyclesService;

    @PostMapping("/createReleaseCycle")
    public ResponseEntity createReleaseCycle(@RequestBody ReleaseCycle releaseCycle) {
        manageReleaseCyclesService.createReleaseCycle(releaseCycle);
        return null;
    }
}
