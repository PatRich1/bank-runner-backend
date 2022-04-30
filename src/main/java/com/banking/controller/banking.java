package com.banking.controller;

import com.banking.models.clientProfile;
import com.banking.models.loanApplication;
import com.banking.models.managerCredentials;
import com.banking.repositories.loanApplicationRepo;
import com.banking.repositories.managerCredentialsRepo;
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
//xyz
@RestController
@CrossOrigin(origins="http://revature-bank-runner.s3-website-us-east-1.amazonaws.com, http://localhost:4200")
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
    @Autowired
    loanApplicationService applicationFactory;
    @Autowired
    managerCredentialsRepo managerFactory;
    @Autowired
    loanApplicationRepo  loanAppRepo;



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

            res.addHeader("Access-Control-Allow-Origin","*");
            res.addHeader("Access-Control-Allow-Credentials","true");

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

    @RequestMapping(value="/loanApplication", method = RequestMethod.POST)
    public void submitLoanApp
            (HttpServletRequest req, HttpServletResponse res,
             @RequestParam(value="fname") String fname,
             @RequestParam(value="minit") String midInitial,
             @RequestParam(value="lname") String lname,
             @RequestParam(value="dob") String dob,
             @RequestParam(value="email") String email,
             @RequestParam(value="maritalStatus") String maritalStatus,
             @RequestParam(value="street") String street,
             @RequestParam(value="city") String city,
             @RequestParam(value="state") String state,
             @RequestParam(value="zip") String zip,
             @RequestParam(value="ssNum") String ssNum,
             @RequestParam(value="phone") String phone,
             @RequestParam(value="loanAmount") int amount,
             @RequestParam(value="loanPurpose") String purpose,
             @RequestParam(value="salary") int salary,
             @RequestParam(value="decision") String decision,
             @RequestParam(value="status") String status
            ) throws IOException {

            loanApplication loan = new loanApplication();

            loan.setFname(fname);
            loan.setMidInitial(midInitial);
            loan.setLname(lname);
            loan.setDOB(dob);
            loan.setEmail(email);
            loan.setMaritalStatus(maritalStatus);
            loan.setStreet(street);
            loan.setCity(city);
            loan.setState(state);
            loan.setZip(zip);
            loan.setSsNum(ssNum);
            loan.setPhone(phone);
            loan.setLoanAmount(amount);
            loan.setLoanPurpose(purpose);
            loan.setSalary(salary);
            loan.setDescription(decision);
            loan.setStatus(status);

            applicationFactory.submitLoanApp(loan);




    }

    @RequestMapping(value="/managerLogin", method = RequestMethod.POST)
    public @ResponseBody managerCredentials managerLogin(HttpServletRequest req, HttpServletResponse res,
                           @RequestParam(value="uname") String uname,
                           @RequestParam(value="pass") String pass) throws IOException {

                Optional<managerCredentials> result = managerFactory.findByUsernameAndPassword(uname,pass);
                managerCredentials manager = null;


                if(result.isPresent()) {
                    manager = result.get();
                    Cookie managerLogin = new Cookie("managerLogin","yes");
                    res.addCookie(managerLogin);
                    Cookie error = new Cookie("error","no");
                    res.addCookie(error);

                    Cookie managerName = new Cookie("uname",manager.getUname());
                    Cookie fname = new Cookie("fname",manager.getFname());
                    Cookie lname = new Cookie("lname",manager.getLname());
                    res.addCookie(managerName);
                    res.addCookie(fname);
                    res.addCookie(lname);









                }
                else {

                    Cookie managerLogin = new Cookie("managerLogin","no");
                    res.addCookie(managerLogin);
                    Cookie error = new Cookie("error","yes");
                    res.addCookie(error);
                }
                return manager;

    }
    @RequestMapping(value="/loanFind",method = RequestMethod.GET)
    public @ResponseBody ArrayList<loanApplication> loanRetrieve(){

        ArrayList<loanApplication> allLoans = applicationFactory.findAll();
        return allLoans;


    }

    @RequestMapping(value="/loanUpdate",method=RequestMethod.PUT)
    public void loanDecision(HttpServletRequest req, HttpServletResponse res,
                             @RequestParam(value="appId") int appId,
                             @RequestParam(value="status") String status,
                            @RequestParam(value="description") String description){

        Optional<loanApplication> applicant = loanAppRepo.findById(appId);
        if(applicant.isPresent()) {
            loanApplication loan = applicant.get();

            loan.setApp_id(appId);
            loan.setStatus(status);
            loan.setDescription(description);

            applicationFactory.updateLoanApp(loan);

        }


    }


    }













