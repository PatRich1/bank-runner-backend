package com.banking.services;

import com.banking.models.checkingAccountInfo;
import com.banking.repositories.checkingAccountInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class checkingServiceimpl implements checkingService {

    private final checkingAccountInfoRepo checking;

    @Autowired
    public checkingServiceimpl (checkingAccountInfoRepo checking){
        this.checking = checking;
    }

    @Override
    public checkingAccountInfo create(checkingAccountInfo checkingAccountInfo) {
        return checking.save(checkingAccountInfo);
    }

    @Override
    public List<checkingAccountInfo> findall() {
        return checking.findAll();
    }

    @Override
    public List<checkingAccountInfo> findallbyid(int id) {
        return checking.findByClientId(id);
    }

    @Override
    public checkingAccountInfo get(int id) {
        return checking.findById(id).get();
    }

    @Override
    public checkingAccountInfo update(checkingAccountInfo checkingAccountInfo) {
        return checking.save(checkingAccountInfo);
    }

    @Override
    public void delete(int id) {
        checking.deleteById(id);
    }
}
