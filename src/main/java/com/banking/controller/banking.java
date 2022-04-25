package com.banking.controller;

import com.banking.models.clientProfile;
import com.banking.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@RestController
public class banking {
    @Autowired
    private transactionHistoryService transactionHistoryService;
    @Autowired
    private checkingService checkingAccService;
    @Autowired
    private savingsAccServiceimpl savingsAccServiceimpl;
    @Autowired
    private clientProfileRegistrationService service;
    @Autowired
    clientProfileService account;



    @RequestMapping(value="/registerNewAccount", method = RequestMethod.POST)
    public void createNewAccount
            (HttpServletRequest req, HttpServletResponse res,
             @RequestParam(value="fname") String fname,
             @RequestParam(value="midInitial") String midInitial,
             @RequestParam(value="lname") String lname,
             @RequestParam(value="email") String email,
             @RequestParam(value="phone") String phone,
             @RequestParam(value="street") String street,
             @RequestParam(value="city") String city,
             @RequestParam(value="state") String state,
             @RequestParam(value="zipcode") String zipcode,
             @RequestParam(value="ssNum") String ssNum,
             @RequestParam(value="uname") String uname,
             @RequestParam(value="pass") String pass,
             @RequestParam(value="passConfirm") String passConfirm
             ) throws IOException {


        clientProfile profile = new clientProfile();
        profile.setFname(fname);
        profile.setMiddleInit(midInitial);
        profile.setLname(lname);
        profile.setEmail(email);
        profile.setPhone(phone);
        profile.setStreet(street);
        profile.setCity(city);
        profile.setState(state);
        profile.setZip(zipcode);
        profile.setSsNum(ssNum);
        profile.setUname(uname);
        profile.setPass(pass);
        System.out.println(profile);

        ArrayList<clientProfile> userCheck = account.existingClientCheck(ssNum);


        if(pass.equals(passConfirm) && userCheck.isEmpty())
        {
            account.addNewAccount(profile);
        }
        else if (!pass.equals(passConfirm))  {System.out.println("passwords don't match");}

        else if(userCheck.size() == 1) {System.out.println("client is already in system");}

        else {System.out.println("Something went wrong");}

    }



    @RequestMapping(value="/loginCheck", method = RequestMethod.POST)
    public void loginCheck(HttpServletRequest req, HttpServletResponse res,
             @RequestParam(value="uname") String uname,
             @RequestParam(value="pass") String pass) throws IOException {


        ArrayList<clientProfile> result = account.loginCheck(uname, pass);


        if (result.isEmpty()) {
            System.out.println("no matching creds");
        } else {
            clientProfile user = result.get(0);

            Cookie loggedIn = new Cookie("loggedIn", "true");
            res.addCookie(loggedIn);

            Cookie username = new Cookie("username", uname);
            res.addCookie(username);

            Cookie firstName = new Cookie("firstName", user.getFname());
            res.addCookie(firstName);

            Cookie lastName = new Cookie("lastName", user.getLname());
            res.addCookie(lastName);

            Cookie ID = new Cookie("ID", Long.toString(user.getClientId()));
            res.addCookie(ID);

        }
    }


        @RequestMapping(value="/myProfilePage", method = RequestMethod.POST)
        public @ResponseBody clientProfile renderProfileDetails(HttpServletRequest req, HttpServletResponse res,
                        @RequestParam(value="ID") int clientID){

            System.out.println("we made the connection on init");
            clientProfile clientInfo = null;

            Optional<clientProfile> result = account.profileInfoRetrieve(clientID);

            if (result.isPresent()) { clientInfo = result.get();}

            else {System.out.println("Error retrieving current user's information");}
            
            return clientInfo;






    }


    @PutMapping(value="/updateAccount")
    public void updateAccount
            (HttpServletRequest req, HttpServletResponse res,
             @RequestParam(value="fname") String fname,
             @RequestParam(value="midInitial") String midInitial,
             @RequestParam(value="lname") String lname,
             @RequestParam(value="email") String email,
             @RequestParam(value="phone") String phone,
             @RequestParam(value="street") String street,
             @RequestParam(value="city") String city,
             @RequestParam(value="state") String state,
             @RequestParam(value="zipcode") String zipcode,
             @RequestParam(value="ssNum") String ssNum,
             @RequestParam(value="uname") String uname,
             @RequestParam(value="pass") String pass,
             @RequestParam(value="passConfirm") String passConfirm,
             @RequestParam(value="ID") int ID
            ) throws IOException {


        clientProfile profile = new clientProfile();
        profile.setClientId(ID);
        profile.setFname(fname);
        profile.setMiddleInit(midInitial);
        profile.setLname(lname);
        profile.setEmail(email);
        profile.setPhone(phone);
        profile.setStreet(street);
        profile.setCity(city);
        profile.setState(state);
        profile.setZip(zipcode);
        profile.setSsNum(ssNum);
        profile.setUname(uname);
        profile.setPass(pass);
        System.out.println(profile);




        if(Objects.equals(pass, passConfirm))
        {
        account.addNewAccount(profile);
        }
        else if (!pass.equals(passConfirm))  {System.out.println("passwords don't match");}



        else {System.out.println("Something went wrong");}

    }

    @RequestMapping(value="/verifyEmail")
    public clientProfile verifyEmail(@RequestParam(value="email") String email, HttpServletRequest req, HttpServletResponse res){

        Optional<clientProfile> result = account.emailCheck(email);
        System.out.println(result);
        clientProfile resultSend = null;

        if(result.isPresent()) {
            resultSend = result.get();

            Cookie verified = new Cookie("verified","true");
            res.addCookie(verified);
            Cookie ID = new Cookie("ID",Long.toString(resultSend.getClientId()));
            res.addCookie(ID);
            System.out.println("success");

        }
        else {
            Cookie verified = new Cookie("verified","false");

            res.addCookie(verified);
            System.out.println("fail");

        }

        return resultSend;

    }

        @PutMapping(value="/updatePassword")
        public void updatePassword(@RequestParam(value="pass") String pass,
                                   @RequestParam(value="passConfirm") String passConfirm,
                                   @RequestParam(value="ID") String ID,
                                   HttpServletRequest req, HttpServletResponse res){

        clientProfile newPasswordChange = null;

        Optional<clientProfile> result = account.profileInfoRetrieve(Integer.parseInt(ID));

        if(result.isPresent())
        { newPasswordChange = result.get();
            newPasswordChange.setPass(pass);}




        if(Objects.equals(pass, passConfirm))
        {account.addNewAccount(newPasswordChange);
            System.out.println("on the right track");}

        else {System.out.println("something is wrong");}









    }













}