package com.example.demo.service;

import com.example.demo.model.Associate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AssociateService {
    public Associate createAssociate(Associate associate);
    public List<Associate> getAllAssociate();
    public Associate findByAssociateId(int associateId);
    public List<Associate> findByAssociateName(String associateName);
    public Associate findByEmail(String email);

    public Associate findByMobileNumber(long mobileNumber);

    //public List<Associate> findBySkill(String skill);
    public Associate deleteByAssociateId(int associateId);
    public Associate updateAssociate(int associateId,Associate associate);
    @Query(value="select * from ASSOCIATE e where e.associate_id like %:keyword% or e.associate_name like %:keyword% or e.associate_email like %:keyword% or e.mobile_number like %:keyword%", nativeQuery = true)
    List<Associate> findByKeyword(@Param("keyword") String keyword);


}
