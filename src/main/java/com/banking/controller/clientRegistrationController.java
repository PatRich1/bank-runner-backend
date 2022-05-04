package com.banking.controller;

import com.banking.models.User;
import com.banking.services.clientProfileRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class clientRegistrationController {
    @Autowired
    private clientProfileRegistrationService service;
    @PostMapping("/login")
    public User loginUser(@RequestBody User User) throws Exception {
        String tempEmail= User.getEmail();
        String tempPass= User.getPass();
        User clientObject = null;
        if(tempEmail != null && tempPass != null){
            clientObject = service.fetchClientByEmailAndPassword(tempEmail,tempPass);


        }
        if (clientObject == null) {
            throw new Exception("bad credentials");
        }

        return clientObject;

    }
}
