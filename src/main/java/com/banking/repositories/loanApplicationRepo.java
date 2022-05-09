package com.banking.repositories;
import com.banking.models.loanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface loanApplicationRepo extends JpaRepository<loanApplication, Integer>{






}
