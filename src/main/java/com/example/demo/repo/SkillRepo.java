package com.example.demo.repo;

import com.example.demo.model.Associate;
import com.example.demo.model.Skill;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkillRepo extends JpaRepository<Skill,Integer> {
    @Query
    public Skill deleteBySkillId(int skillId);
    List<Skill> findByAssociate(Associate associate, Sort sort);
}
