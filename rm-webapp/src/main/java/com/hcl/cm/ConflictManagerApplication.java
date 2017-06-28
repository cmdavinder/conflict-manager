package com.hcl.cm;


import com.hcl.cm.entities.Environment;
import com.hcl.cm.entities.Project;
import com.hcl.cm.entities.ReleaseCycle;
import com.hcl.cm.repository.EnvironmentRepository;
import com.hcl.cm.repository.ProjectRespository;
import com.hcl.cm.repository.ReleaseCycleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ConflictManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConflictManagerApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProjectRespository pr, ReleaseCycleRepository rcr, EnvironmentRepository er) {
        return args -> doInit(pr, rcr, er);
        }

    private void doInit(ProjectRespository pr, ReleaseCycleRepository rcr, EnvironmentRepository er) {
        Arrays.asList("p1,p2,p3".split(",")).forEach(e -> {
            Project p = new Project();
            ReleaseCycle r = new ReleaseCycle();
            r.setProject(p);
            r.setName("release cycle 1:" + p.getProjectName());

            ReleaseCycle r1 = new ReleaseCycle();
            r1.setProject(p);
            r1.setName("release cycle 2:" + p.getProjectName());
            p.setProjectName(e);
            pr.save(p);
            rcr.save(r);
            rcr.save(r1);
        });

        Environment env1 = new Environment();
        env1.setName("DEV");
        Environment env2 = new Environment();
        env2.setName("PPE");
        Environment env3 = new Environment();
        env3.setName("PRODUCTION");
        er.save(env1);
        er.save(env2);
        er.save(env3);
    }
}
