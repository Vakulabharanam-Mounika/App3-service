package com.example.demo.repo;

import com.example.demo.model.Associate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssociateRepo extends JpaRepository<Associate,Integer> {
    @Query
    public List<Associate> findByAssociateName(String associateName);

    @Query
    public Associate findByEmail(String email);
    @Query
    public Associate findByMobileNumber(long mobileNumber);
    //@Query
    //public List<Associate> findBySkill(String skill);
    @Query
    public Associate deleteByAssociateId(int associateId);
    @Query(value="select * from ASSOCIATE e where e.associate_id like %:keyword% or e.associate_name like %:keyword% or e.associate_email like %:keyword% or e.mobile_number like %:keyword%", nativeQuery = true)
    List<Associate> findByKeyword(@Param("keyword") String keyword);



}
