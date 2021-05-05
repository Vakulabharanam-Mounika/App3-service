package com.example.demo.model;

import javax.persistence.*;
import java.util.List;
import com.example.demo.model.Skill;

@Entity
@Table(name="associate")
public class Associate {
    @Id
    @Column(name="associate_id")
    private  int associateId;
    @Column(name="associate_name")
    private String associateName;

    @Column(name="associate_email")
    private String email;
    @Column(name="mobile_number")
    private long mobileNumber;

    @OneToMany(mappedBy = "associate", cascade = {
            CascadeType.ALL
    })
    //@JoinColumn(name="skill_name")

    private List<Skill> skills;
    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Associate() {
    }

    public Associate(int associateId, String associateName,String email, long mobileNumber) {

        this.associateId = associateId;
        this.associateName = associateName;
        this.email = email;
        this.mobileNumber = mobileNumber;

    }
    public Associate(String associateName,String email, long mobileNumber) {
        this.associateName = associateName;
        //this.associateId = associateId;
        this.email = email;
        this.mobileNumber = mobileNumber;

    }

    public Associate(int associateId, String associateName,String email, long mobileNumber,List<Skill> skills) {
        this.associateName = associateName;
        this.associateId = associateId;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.skills=skills;

    }

    public String getAssociateName() {
        return associateName;
    }

    public void setAssociateName(String associateName) {
        this.associateName = associateName;
    }

    public int getAssociateId() {
        return associateId;
    }

    public void setAssociateId(int associateId) {
        this.associateId = associateId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return (" "+associateId);
    }
}

