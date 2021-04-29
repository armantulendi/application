package com.example.rulescontrol.repo;

import com.example.rulescontrol.model.Subscriber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriberRepo extends CrudRepository<Subscriber,Integer> {
    @Override
    Optional<Subscriber> findById(Integer id);

    Iterable<Subscriber> getAllByUsername(String filter);

    Subscriber findByUsername(String username);


}
