package com.banking.services;

import com.banking.models.checkingAccountInfo;
import com.banking.models.savingsAccountInfo;

import java.util.Collection;
import java.util.List;

public interface savingsAccService{
    public savingsAccountInfo create (savingsAccountInfo saving);
    List<savingsAccountInfo> findall();
    List<savingsAccountInfo> findallbyid(int id);
    savingsAccountInfo get(long id);
    savingsAccountInfo update(savingsAccountInfo saving);
    void delete (int id);
}
