package com.banking.repositories;

import com.banking.models.clientProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clientRegistrationRepo extends JpaRepository<clientProfile,Long> {

     public clientProfile findByEmailAndPass(String email, String pass);
}
