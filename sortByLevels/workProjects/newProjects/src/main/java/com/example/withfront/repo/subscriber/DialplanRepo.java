package com.example.withfront.repo.subscriber;

import com.example.withfront.model.Dialplan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DialplanRepo extends JpaRepository<Dialplan,Integer> {

    List<Dialplan> findAllByMatchExp(String str);
    @Override
    Optional<Dialplan> findById(Integer integer);
}
