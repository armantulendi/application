package com.project.data.repo;

import com.project.data.model.DrGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DrGroupsRepo extends JpaRepository<DrGroups,Integer> {
    List<DrGroups> findAllByUserName(String username);
    DrGroups findByIdGroup(Integer integer);
}
