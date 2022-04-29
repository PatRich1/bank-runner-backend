package com.banking.services;

import com.banking.models.clientProfile;
import com.banking.models.loanApplication;
import com.banking.repositories.clientProfileRepo;
import com.banking.repositories.loanApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class loanApplicationService {
    @Autowired
    private loanApplicationRepo applicationFactory;

    public void submitLoanApp(loanApplication app) {

        applicationFactory.save(app);

    }
    public ArrayList<loanApplication> findAll() {

        return (ArrayList<loanApplication>) applicationFactory.findAll();
    }


    }