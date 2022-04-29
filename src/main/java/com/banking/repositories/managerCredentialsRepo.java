package com.banking.repositories;



import com.banking.models.managerCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface managerCredentialsRepo extends JpaRepository<managerCredentials, Integer> {

    @Query(value = "SELECT * FROM manager_creds WHERE username =:uname AND password =:pass", nativeQuery = true)
   Optional<managerCredentials> findByUsernameAndPassword(@Param("uname") String uname, @Param("pass") String pass);


}
