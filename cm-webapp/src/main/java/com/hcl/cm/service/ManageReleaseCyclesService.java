package com.hcl.cm.service;

import com.hcl.cm.entities.ReleaseCycle;
import com.hcl.cm.repository.ReleaseCycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageReleaseCyclesService {

    @Autowired
    private ReleaseCycleRepository releaseCycleRepository;

    public ReleaseCycle createReleaseCycle(ReleaseCycle releaseCycle) {
        return releaseCycleRepository.save(releaseCycle);
    }
}
