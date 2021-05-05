package com.example.demo.service;

import com.example.demo.model.Associate;
import com.example.demo.model.Skill;
import com.example.demo.repo.AssociateRepo;
import com.example.demo.repo.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {
    private SkillRepo skillRepo;
    @Autowired
    public SkillServiceImpl(SkillRepo skillRepo) {
        this.skillRepo = skillRepo;
    }

    @Override
    public Skill createSkill(Skill skill) {
        return skillRepo.save(skill);
    }

    @Override
    public List<Skill> getAllSkill() {
        return skillRepo.findAll();
    }

    @Override
    public Skill deleteBySkillId(int skillId) {
        return skillRepo.deleteBySkillId(skillId);
    }

    @Override
    public List<Skill> findByAssociate(Associate associate, Sort sort) {
        return skillRepo.findByAssociate(associate,sort);
    }

    /*@Override
    public Skill updateSkill(int skillId, Skill skill) {
        return ;
    }*/
}
