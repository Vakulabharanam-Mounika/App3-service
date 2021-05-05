package com.example.demo;

import com.example.demo.model.Associate;
import com.example.demo.model.Skill;
import com.example.demo.repo.AssociateRepo;
import com.example.demo.repo.SkillRepo;
//import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.hibernate.cfg.Configuration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.*;

@SpringBootApplication
@EnableEurekaClient


public class SkillServiceApplication implements CommandLineRunner {
    private AssociateRepo associateRepo;
    private SkillRepo skillRepo;
    @Autowired
    public SkillServiceApplication(AssociateRepo associateRepo,SkillRepo skillRepo) {
        super();
        this.associateRepo = associateRepo;
        this.skillRepo=skillRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(SkillServiceApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        Associate a=new Associate(10,"John","john@gmail.com",999999999);
        Associate b=new Associate(90,"merry","merry@gmail.com",990000000);
        Associate c=new Associate(12,"sid","sid@gmail.com",990809000);
        Associate d=new Associate(5,"david","david@gmail.com",990078630);
        associateRepo.save(a);
        associateRepo.save(c);
        associateRepo.save(d);
        associateRepo.save(b);

        skillRepo.save(new Skill(1,"java",a));
        skillRepo.save(new Skill(10,"python",a));
        skillRepo.save(new Skill(1,"java",b));
        skillRepo.save(new Skill(8,"javascript",c));
        skillRepo.save(new Skill(30,"spring",b));
        skillRepo.save(new Skill(8,"javascript",d));
        skillRepo.save(new Skill(30,"spring",d));

    }
}





