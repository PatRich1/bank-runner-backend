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
    private clientProfileRepo profile;

    public void addNewAccount(User account) {

        profile.save(account);


    }

    public ArrayList<User> existingClientCheck(String ssNum) {
        ArrayList<User> userCheck;

        userCheck = profile.findByssNum(ssNum);

        return userCheck;
    }

    public Optional<User> loginCheck(String uname, String pass) {

        Optional<User> result;

        result = profile.findByCreds(uname,pass);

        return result;

    }
    public Optional<User> profileInfoRetrieve(int ID) {

        Optional<User> result;

        result = profile.findById(ID);

        return result;

    }
    public Optional<User> emailCheck(String email) {

        Optional<User> result;

        result = profile.findByEmail(email);

        return result;

    }

    public User findbyemail (String email) {
        return profile.findByEmail(email).orElseThrow(()-> new UserNotFoundException("User by email"+ email +"was not found"));
    }

    public User findByClientId(int id){
        return profile.findById(id).orElseThrow(()-> new UserNotFoundException("User by id"+ id +"was not found"));
    }




}
