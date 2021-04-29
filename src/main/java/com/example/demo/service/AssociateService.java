package com.example.demo.service;

import com.example.demo.model.Associate;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AssociateService {
    public Associate createAssociate(Associate associate);
    public List<Associate> displayAllAssociate();
    public Associate findByAssociateId(int associateId);
    public List<Associate> findByAssociateName(String associateName);
    public Associate findByEmail(String email);

    public Associate findByMobileNumber(int mobileNumber);

    //public List<Associate> findBySkill(String skill);
    public Associate deleteByAssociateId(int associateId);
    public Associate updateAssociate(int associateId,Associate associate);

}
