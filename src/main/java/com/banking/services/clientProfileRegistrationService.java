package com.banking.services;

import com.banking.models.User;
import com.banking.repositories.clientRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class clientProfileRegistrationService {
    @Autowired
    private clientRegistrationRepo repo;



    public User fetchClientByEmailAndPassword(String tempEmail, String tempPass) {
        return repo.findByEmailAndPass(tempEmail,tempPass);
    }
}
