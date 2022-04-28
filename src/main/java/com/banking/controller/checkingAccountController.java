package com.banking.controller;


import com.banking.models.checkingAccountInfo;
import com.banking.services.checkingServiceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checking")
public class checkingAccountController {

    private final checkingServiceimpl checking;
    @Autowired
    public checkingAccountController(checkingServiceimpl checking) {
        this.checking = checking;
    }

    @GetMapping("/all")
    public ResponseEntity<List<checkingAccountInfo>> getallaccounts(){
        List<checkingAccountInfo> accounts = checking.findall();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/findbyid/{chk_acc_num}")
    public ResponseEntity<checkingAccountInfo> findbyid(@PathVariable("chk_acc_num") long id){
        checkingAccountInfo accounts = checking.get(id);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    @GetMapping("/findall/{Client_ID}")
    public ResponseEntity<List<checkingAccountInfo>> findallbyid(@PathVariable("Client_ID") int id){
        if (id == 0){
            return null;
        }
        List<checkingAccountInfo> accounts = checking.findallbyid(id);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<checkingAccountInfo> create(@RequestBody checkingAccountInfo account){
        checkingAccountInfo newAccount = checking.create(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<checkingAccountInfo> update(@RequestBody checkingAccountInfo account){
        checkingAccountInfo updateAccount = checking.update(account);
        return new ResponseEntity<>(updateAccount, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{dummy_PK}")
    public ResponseEntity<?> delete(@PathVariable("dummy_PK") int id){
        checking.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
