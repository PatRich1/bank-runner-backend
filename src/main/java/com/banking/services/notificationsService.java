package com.banking.services;

import com.banking.models.notifications;

import java.util.List;


public interface notificationsService {

    public notifications create (notifications notifications);
    List<notifications> findall();
    List<notifications> findallbyid(int id);
    notifications get(int id);
    notifications update(notifications notifications);
    void delete (int id);
}
