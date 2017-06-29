package com.hcl.cm;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.hcl.cm.entities.*;
import com.hcl.cm.repository.*;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ConflictManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConflictManagerApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProjectRespository pr, ReleaseCycleRepository rcr, EnvironmentRepository er, CiReservationRepository crr, ConfigurationItemRepository cir) {
        return args -> doInit(pr, rcr, er, crr, cir);
    }

    private void doInit(ProjectRespository pr, ReleaseCycleRepository rcr, EnvironmentRepository er, CiReservationRepository crr, ConfigurationItemRepository cir) throws ParseException {



        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Project project1 = new Project();
        Project project2 = new Project();

        ReleaseCycle rc1 = new ReleaseCycle();
        ReleaseCycle rc2 = new ReleaseCycle();
        ReleaseCycle rc3 = new ReleaseCycle();


        ConfigurationItem ci1 = new ConfigurationItem();

        CiReservation cr1 = new CiReservation();
        CiReservation cr2 = new CiReservation();
        CiReservation cr3 = new CiReservation();

        Environment env1 = new Environment();
        Environment env2 = new Environment();
        Environment env3 = new Environment();

        //ENVIRONMENTS------------
        env1.setName("DEV");
        env2.setName("PPE");
        env3.setName("PRODUCTION");


        //PROJECTS--------
        project1.setProjectName("P1");
        project2.setProjectName("P2");

        //RELEASE CYCLES--------
        rc1.setName("RC1");
        rc2.setName("RC2");
        rc3.setName("RC3");
        rc1.setStartDate(sdf.parse("15/01/2017"));
        rc1.setEndDate(sdf.parse("15/02/2017"));
        rc2.setStartDate(sdf.parse("01/01/2017"));
        rc2.setEndDate(sdf.parse("01/02/2017"));
        rc3.setStartDate(sdf.parse("20/01/2018"));
        rc3.setEndDate(sdf.parse("30/01/2018"));
        rc1.setProject(project1);
        rc2.setProject(project1);
        rc3.setProject(project2);
        rc1.setEnvironment(env1);
        rc2.setEnvironment(env1);
        rc3.setEnvironment(env1);


        //COONFIGURATION ITEMS----------
        ci1.setName("CI1");
        ci1.setId(1L);


        //CI RESERVATIONS--------
        cr1.setCi(ci1);
        cr1.setEnvironment(env1);
        cr1.setProject(project1);
        cr1.setReleaseCycle(rc1);

        cr2.setCi(ci1);
        cr2.setEnvironment(env1);
        cr2.setProject(project1);
        cr2.setReleaseCycle(rc2);

        cr3.setCi(ci1);
        cr3.setEnvironment(env1);
        cr3.setProject(project2);
        cr3.setReleaseCycle(rc3);


        List<CiReservation> ciReservations = new ArrayList<>();
        ciReservations.add(cr1);
        ciReservations.add(cr2);
        ciReservations.add(cr3);

        er.save(env1);
        er.save(env2);
        er.save(env3);

        pr.save(project1);
        pr.save(project2);

        rcr.save(rc1);
        rcr.save(rc2);
        rcr.save(rc3);

        cir.save(ci1);


        crr.save(cr1);
        crr.save(cr2);
        crr.save(cr3);


        try {
            postAction(crr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private void postAction(CiReservationRepository crr) throws JsonProcessingException {


    }
}
