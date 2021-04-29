package com.example.demo.service;

import com.example.demo.model.Associate;
import com.example.demo.repo.AssociateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssociateServiceImpl implements AssociateService{
    private AssociateRepo associateRepo;
    @Autowired
    public AssociateServiceImpl(AssociateRepo associateRepo) {
        this.associateRepo = associateRepo;
    }

    @Override
    public Associate createAssociate(Associate associate) {
        return associateRepo.save(associate);
    }

    @Override
    public List<Associate> displayAllAssociate() {
        return associateRepo.findAll();
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
            // we didn't find the employee
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
    public Associate findByMobileNumber(int mobileNumber) {
        return associateRepo.findByMobileNumber(mobileNumber);
    }

    /*@Override
    public List<Associate> findBySkill(String skill) {
        return associateRepo.findBySkill(skill);
    }*/

    @Override
    public Associate deleteByAssociateId(int associateId) {
        return null;
    }

    @Override
    public Associate updateAssociate(int associateId, Associate associate) {
        return null;
    }

}
