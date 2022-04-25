package com.banking.services;


import com.banking.models.checkingAccountInfo;
import com.banking.models.savingsAccountInfo;
import com.banking.repositories.savingsAccountInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.*;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class savingsAccServiceimpl implements savingsAccService{


    private final savingsAccountInfoRepo service;
    @Autowired
    public savingsAccServiceimpl(savingsAccountInfoRepo service) {
        this.service = service;
    }


    @Override
    public savingsAccountInfo create(savingsAccountInfo saving) {
        return service.save(saving);
    }

    @Override
    public List<savingsAccountInfo> findall(){
        return service.findAll();
    }

    @Override
    public List<savingsAccountInfo> findallbyid(int id) {
        return service.findByClientId(id);
    }

    @Override
    public savingsAccountInfo get(int id) {
        return service.findById(id).get();
    }

    @Override
    public savingsAccountInfo update(savingsAccountInfo saving) {
        return service.save(saving);
    }

    @Override
    public void delete(int id) {
        service.deleteById(id);
    }
}
