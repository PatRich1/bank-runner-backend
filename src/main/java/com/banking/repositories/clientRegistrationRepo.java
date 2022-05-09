package com.banking.repositories;

import com.banking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clientRegistrationRepo extends JpaRepository<User,Long> {

     public User findByEmailAndPass(String email, String pass);
}
