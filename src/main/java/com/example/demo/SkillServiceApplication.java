package com.example.demo;

import com.example.demo.model.Associate;
import com.example.demo.model.Skill;
import com.example.demo.repo.AssociateRepo;
import com.example.demo.repo.SkillRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
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
        Skill java=new Skill(1,"java");
        Skill spring=new Skill(2,"spring");
       
        //associateRepo.save(new Associate(1,"john","vv@g",9999));
        List<Skill> s= new ArrayList<>();
        s.add(java);
        s.add(spring);
        Associate a=new Associate();
        a.setSkills(s);

        associateRepo.save(new Associate(1,"john","vv@gmail.com",99999));




    }
}





