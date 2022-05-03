package com.banking.controller;

import com.banking.models.User;
import com.banking.models.UserRole;
import com.banking.models.loanApplication;
import com.banking.repositories.loanApplicationRepo;
import com.banking.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private clientProfileRegistrationService registrationService;
    @Autowired
    clientProfileService clientProfileService;
    @Autowired
    loanApplicationService applicationFactory;
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
             @RequestParam(value="passConfirm") String passConfirm,
             @RequestParam(value="role") String role
             ) throws IOException {


        User profile = new User();
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
        profile.setRole(UserRole.valueOf(role));
        System.out.println(profile);

        ArrayList<User> userCheck = clientProfileService.existingClientCheck(ssNum);

        if(pass.equals(passConfirm) && userCheck.isEmpty())
        {
            clientProfileService.addNewAccount(profile);
        }
        else if (!pass.equals(passConfirm))  {System.out.println("passwords don't match");}

        else if(userCheck.size() == 1) {System.out.println("client is already in system");}

        else {System.out.println("Something went wrong");}

    }

    @RequestMapping(value="/loginCheck", method = RequestMethod.POST)
    public ResponseEntity<User> loginCheck(HttpServletRequest req, HttpServletResponse res,
                                         @RequestParam(value="uname") String uname,
                                         @RequestParam(value="pass") String pass) throws IOException {


        ArrayList<User> result = clientProfileService.loginCheck(uname, pass);
        User user = null;


        if (result.isEmpty()) {
            return ResponseEntity.badRequest().build(); // Send back 400
        } else { user = result.get(0);}
        return ResponseEntity.ok(user); // Send status code 200
    }


        @RequestMapping(value="/myProfilePage", method = RequestMethod.POST)
        public @ResponseBody User renderProfileDetails(HttpServletRequest req, HttpServletResponse res,
                                                       @RequestParam(value="ID") int clientID){

            System.out.println("we made the connection on init");
            User clientInfo = null;

            Optional<User> result = clientProfileService.profileInfoRetrieve(clientID);

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
             @RequestParam(value="ID") String ID
            ) throws IOException {


        User profile = new User();
        profile.setId(Integer.parseInt(ID));
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
        clientProfileService.addNewAccount(profile);
        }
        else if (!pass.equals(passConfirm))  {System.out.println("passwords don't match");}



        else {System.out.println("Something went wrong");}

    }

    @RequestMapping(value="/verifyEmail")
    public @ResponseBody User verifyEmail(@RequestParam(value="email") String email, HttpServletRequest req, HttpServletResponse res){

        Optional<User> result = clientProfileService.emailCheck(email);

        User resultSend = null;

        if(result.isPresent()) {
            resultSend = result.get();




        }
        else {



        }

        return resultSend;

    }

        @PutMapping(value="/updatePassword")
        public void updatePassword(@RequestParam(value="pass") String pass,
                                   @RequestParam(value="passConfirm") String passConfirm,
                                   @RequestParam(value="ID") String ID,
                                   HttpServletRequest req, HttpServletResponse res){

        User newPasswordChange = null;

        Optional<User> result = clientProfileService.profileInfoRetrieve(Integer.parseInt(ID));

        if(result.isPresent())
        { newPasswordChange = result.get();
            newPasswordChange.setPass(pass);}




        if(Objects.equals(pass, passConfirm))
        {
            clientProfileService.addNewAccount(newPasswordChange);
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

    @GetMapping("/findbyemail/{email}")
    public ResponseEntity<User> findbyemail(@PathVariable("email") String email){
        User profile = clientProfileService.findbyemail(email);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @GetMapping("/findbyCid/{Client_ID}")
    public ResponseEntity<User> findbyemail(@PathVariable("Client_ID") int id){
        User profile = clientProfileService.findById(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

}
