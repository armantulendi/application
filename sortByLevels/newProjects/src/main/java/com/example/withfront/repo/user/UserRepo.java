package com.example.withfront.repo.user;

import com.example.withfront.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    //для работы со сущностью User
  User findByUsername(String username);

    Optional<User> findUserByUsername(String username);

    List<User> getAllByUsername(String username);
}
