package com.banking.repositories;

import com.banking.models.notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

@Repository
public interface notificationsRepo extends JpaRepository<notifications,Integer> {
    List<notifications> findByClientId(int clientID);

    @Override
    List<notifications> findAll();

    @Override
    Optional<notifications> findById(Integer integer);
}
