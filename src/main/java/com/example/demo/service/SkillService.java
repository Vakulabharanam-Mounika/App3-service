package com.example.demo.service;

import com.example.demo.model.Associate;
import com.example.demo.model.Skill;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SkillService {

    public Skill createSkill(Skill skill);
    public List<Skill> getAllSkill();


    //public List<Associate> findBySkill(String skill);
    public Skill deleteBySkillId(int skillId);
    //public Skill updateSkill(int skillId,Skill skill);
    List<Skill> findByAssociate(Associate associate, Sort sort);

}

