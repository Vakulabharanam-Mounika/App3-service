package com.example.demo.repo;

import com.example.demo.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepo extends JpaRepository<Skill,Integer> {
}
