package com.banking.controller;

import com.banking.models.checkingAccountInfo;
import com.banking.models.savingsAccountInfo;
import com.banking.services.savingsAccServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/savings")
public class savingAccountController {
    private final savingsAccServiceimpl saving;
    @Autowired
    public savingAccountController(savingsAccServiceimpl saving) {
        this.saving = saving;
    }

    @GetMapping("/all")
    public ResponseEntity<List<savingsAccountInfo>> getallaccounts(){
        List<savingsAccountInfo> accounts = saving.findall();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/findbyid/{dummy_PK}")
    public ResponseEntity<savingsAccountInfo> findbyid(@PathVariable("dummy_PK") int id){
        savingsAccountInfo accounts = saving.get(id);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    @GetMapping("/findall/{Client_ID}")
    public ResponseEntity<List<savingsAccountInfo>> findallbyid(@PathVariable("Client_ID") int id){
        if (id == 0){
            return null;
        }
        List<savingsAccountInfo> accounts = saving.findallbyid(id);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<savingsAccountInfo> create(@RequestBody savingsAccountInfo account){
        savingsAccountInfo newAccount = saving.create(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<savingsAccountInfo> update(@RequestBody savingsAccountInfo account){
        savingsAccountInfo updateAccount = saving.update(account);
        return new ResponseEntity<>(updateAccount, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{dummy_PK}")
    public ResponseEntity<?> delete(@PathVariable("dummy_PK") int id){
        saving.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
