package com.example.withfront.repo.subscriber;

import com.example.withfront.model.Subscriber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriberRepo extends CrudRepository<Subscriber,Integer> {
    List<Subscriber> getAllByUsername(String filter);
    Subscriber findByUsername(String username);


    List<Subscriber> findAllByUsername(String filter);
}
