package com.banking.controller;

import com.banking.models.notifications;
import com.banking.models.savingsAccountInfo;
import com.banking.services.notificationsServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notifications")
public class notificationController {
    private final notificationsServiceimpl notification;
    @Autowired
    public notificationController(notificationsServiceimpl notification) {
        this.notification = notification;
    }

    @GetMapping("/all")
    public ResponseEntity<List<notifications>> getallnotifications(){
        List<notifications> notes = notification.findall();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<notifications> findbyid(@PathVariable("id") int id){
        notifications notes = notification.get(id);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }
    @GetMapping("/findall/{Client_ID}")
    public ResponseEntity<List<notifications>> findallbyid(@PathVariable("Client_ID") int id){
        if (id == 0){
            return null;
        }
        List<notifications> notes = notification.findallbyid(id);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<notifications> create(@RequestBody notifications notes){
        notifications newNotes = notification.create(notes);
        return new ResponseEntity<>(newNotes, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<notifications> update(@RequestBody notifications notes){
        notifications updateNotes = notification.update(notes);
        return new ResponseEntity<>(updateNotes, HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        notification.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
