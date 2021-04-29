package com.example.withfront.repo.subscriber;

import com.example.withfront.model.DrGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DrGroupsRepo extends JpaRepository<DrGroups,Integer> {
    List<DrGroups> findAllByUserName( String username);
    DrGroups findByIdGroup(Integer integer);
}
