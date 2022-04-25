package com.banking.services;

import com.banking.repositories.transactionHistoryRepo;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class transactionHistoryService {

    @Autowired
    private transactionHistoryRepo transactions;
}
