package com.example.sweater.repos;

import com.example.sweater.domain.other.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    //для работы со сущностью User
   User findByUsername(String username);
   List<User> getAllByUsername(String username);
}
