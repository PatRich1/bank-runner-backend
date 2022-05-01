package com.banking.services;

import com.banking.exception.UserNotFoundException;
import com.banking.models.clientProfile;
import com.banking.repositories.clientProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class clientProfileService  {
    @Autowired
    private clientProfileRepo profile;

    public void addNewAccount(clientProfile account) {

        profile.save(account);


    }

    public ArrayList<clientProfile> existingClientCheck(String ssNum) {
        ArrayList<clientProfile> userCheck;

        userCheck = profile.findByssNum(ssNum);

        return userCheck;
    }

    public ArrayList<clientProfile> loginCheck(String uname, String pass) {

        ArrayList<clientProfile> result;

        result = profile.findByCreds(uname,pass);

        return result;

    }
    public Optional<clientProfile> profileInfoRetrieve(int ID) {

        Optional<clientProfile> result;

        result = profile.findById(ID);

        return result;

    }
    public Optional<clientProfile> emailCheck(String email) {

        Optional<clientProfile> result;

        result = profile.findByEmail(email);

        return result;

    }

    public clientProfile findbyemail (String email) {
        return profile.findByEmail(email).orElseThrow(()-> new UserNotFoundException("User by email"+ email +"was not found"));
    }

    public clientProfile findByClientId(int id){
        return profile.findByClientId(id).orElseThrow(()-> new UserNotFoundException("User by id"+ id +"was not found"));
    }




}
