package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="skill")
public class Skill{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="skill_id")
    private int skillId;

    @Column(name="skill_name")
    private String skillName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "associateId")
    private Associate associate;

    public Associate getAssociate() {
        return associate;
    }

    public void setAssociates(Associate associate) {
        this.associate = associate;
    }

    public Skill() {

    }

    public Skill(String skillName) {
        this.skillName = skillName;
    }

    public Skill(int skillId, String skillName,Associate associate) {
        this.skillId = skillId;
        this.skillName=skillName;
        this.associate=associate;
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

    @Override
    public String toString() {
        return (" "+ skillName) ;
    }
}
