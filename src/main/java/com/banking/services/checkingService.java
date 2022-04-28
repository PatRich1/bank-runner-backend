package com.banking.services;
import com.banking.models.checkingAccountInfo;

import java.util.Collection;
import java.util.List;

public interface checkingService {
    public checkingAccountInfo create (checkingAccountInfo checkingAccountInfo);
    List<checkingAccountInfo> findall();
    List<checkingAccountInfo> findallbyid(int id);
    checkingAccountInfo get(long id);
    checkingAccountInfo update(checkingAccountInfo checkingAccountInfo);
    void delete (int id);
}
