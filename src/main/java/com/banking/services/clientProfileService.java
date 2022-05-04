package com.banking.services;

import com.banking.exception.UserNotFoundException;
import com.banking.models.User;
import com.banking.repositories.clientProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class clientProfileService  {
    @Autowired
    private clientProfileRepo profileRepo;

    public void addNewAccount(User account) {

        profileRepo.save(account);


    }

    public ArrayList<User> existingClientCheck(String ssNum) {
        ArrayList<User> userCheck;

        userCheck = profileRepo.findByssNum(ssNum);

        return userCheck;
    }

    public ArrayList<User> loginCheck(String uname, String pass) {

        ArrayList<User> result;

        result = profileRepo.findByCreds(uname,pass);

        return result;

    }
    public Optional<User> profileInfoRetrieve(int ID) {

        Optional<User> result;

        result = profileRepo.findById(ID);

        return result;

    }
    public Optional<User> emailCheck(String email) {

        Optional<User> result;

        result = profileRepo.findByEmail(email);

        return result;

    }

    public User findbyemail (String email) {
        return profileRepo.findByEmail(email).orElseThrow(()-> new UserNotFoundException("User by email"+ email +"was not found"));
    }

    public User findById(int id){
        return profileRepo.findById(id).orElseThrow(()-> new UserNotFoundException("User by id"+ id +"was not found"));
    }
}
