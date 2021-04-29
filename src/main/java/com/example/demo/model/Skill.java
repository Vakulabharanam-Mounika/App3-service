package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="skill")
public class Skill{

    // define our fields

    // define constructors

    // define getter setters

    // define tostring

    // annotate fields

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="skill_id")
    private int skillId;

    @Column(name="skill_name")
    private String skillName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "associate_id")
    private Associate associate;


    public Associate getAssociate() {
        return associate;
    }

    public void setAssociate(Associate associate) {
        this.associate = associate;
    }

    public Skill() {

    }

    public Skill(int skillId,String skillName) {
        this.skillId = skillId;
        this.skillName=skillName;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }




}
