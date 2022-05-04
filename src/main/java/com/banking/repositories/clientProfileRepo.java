package com.banking.repositories;

import com.banking.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface clientProfileRepo extends JpaRepository<User, Integer> {


    @Query(value = "SELECT * FROM client_profile WHERE ss_num =:ssNum ", nativeQuery = true)
    ArrayList<User> findByssNum(@Param("ssNum") String ssNum);

    @Query(value = "SELECT * FROM client_profile WHERE u_name =:uname AND pass =:pass", nativeQuery = true)
    ArrayList<User> findByCreds(@Param("uname") String uname, @Param("pass") String pass);

    @Query
    Optional<User> findByEmail(String email);

    Optional<User> findById(int id);


}
