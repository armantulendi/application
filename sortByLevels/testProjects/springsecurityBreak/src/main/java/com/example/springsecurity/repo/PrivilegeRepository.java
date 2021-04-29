package com.example.springsecurity.repo;

import com.example.springsecurity.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege,Long> {

  Privilege findByName(String aLong);
}
