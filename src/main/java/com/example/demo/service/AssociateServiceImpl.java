package com.example.demo.service;

import com.example.demo.model.Associate;
import com.example.demo.model.Skill;
import com.example.demo.repo.AssociateRepo;
import com.example.demo.repo.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssociateServiceImpl implements AssociateService {
    private AssociateRepo associateRepo;
    private SkillRepo skillRepo;
    @Autowired
    public AssociateServiceImpl(AssociateRepo associateRepo,SkillRepo skillRepo) {

        this.associateRepo = associateRepo;
        this.skillRepo=skillRepo;
    }

    @Override
    public Associate createAssociate(Associate associate) {
        Skill s=new Skill();

        //associate.setSkills(associate.getSkills());
        s.setAssociates(s.getAssociate());
        skillRepo.save(s);

        return associateRepo.save(associate);
    }

    @Override
    public List<Associate> getAllAssociate() {
        return associateRepo.findAll();

    }
    @Override
    public List<Associate> findByKeyword(String keyword) {
        return associateRepo.findByKeyword(keyword);
    }

    @Override
    public Associate findByAssociateId(int associateId) {

        Associate associate=null;
        Optional<Associate> a=associateRepo.findById(associateId);

        if(a.isPresent())
        {
            associate=a.get();
        }
        else {

            throw new RuntimeException("Did not find associate id - " + associateId);
        }
        return associate;
    }

    @Override
    public List<Associate> findByAssociateName(String associateName) {
        return associateRepo.findByAssociateName(associateName);
    }

    @Override
    public Associate findByEmail(String email) {
        return associateRepo.findByEmail(email);
    }

    @Override
    public Associate findByMobileNumber(long mobileNumber) {
        return associateRepo.findByMobileNumber(mobileNumber);
    }

    @Override
    public Associate deleteByAssociateId(int associateId) {
        return null;
    }

    @Override
    public Associate updateAssociate(int associateId, Associate associate) {
        return null;
    }

}
