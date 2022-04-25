package com.banking.repositories;

import com.banking.models.checkingAccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface checkingAccountInfoRepo extends JpaRepository<checkingAccountInfo,Integer> {

    @Override
    checkingAccountInfo getById(Integer integer);

    @Override
    List<checkingAccountInfo> findAll();

    List<checkingAccountInfo> findByClientId(int id);
}
