package com.banking.services;

import com.banking.exception.UserNotFoundException;
import com.banking.models.notifications;
import com.banking.repositories.notificationsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class notificationsServiceimpl implements notificationsService{

    private final notificationsRepo service;
    @Autowired
    public notificationsServiceimpl(notificationsRepo service) {
        this.service = service;
    }

    @Override
    public notifications create(notifications notifications) {
        return service.save(notifications);
    }

    @Override
    public List<notifications> findall() {
        return service.findAll();
    }

    @Override
    public List<notifications> findallbyid(int id) {
        return service.findByClientId(id);
    }

    @Override
    public notifications get(int id) {
        return service.findById(id).orElseThrow(()-> new UserNotFoundException("User by id"+ id +"was not found"));
    }

    @Override
    public notifications update(notifications notifications) {
        return service.save(notifications);
    }

    @Override
    public void delete(int id) {
        service.deleteById(id);
    }
}
