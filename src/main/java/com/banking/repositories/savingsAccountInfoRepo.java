package com.banking.repositories;

import com.banking.models.savingsAccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface savingsAccountInfoRepo extends JpaRepository<savingsAccountInfo,Integer> {
    savingsAccountInfo findBySavAccNum(long id);

    @Override
    List<savingsAccountInfo> findAll();

    List<savingsAccountInfo> findByClientId(int id);
}
