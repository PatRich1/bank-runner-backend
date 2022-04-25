package com.banking.repositories;

import com.banking.models.transactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface transactionHistoryRepo extends JpaRepository<transactionHistory,Integer> {
}
