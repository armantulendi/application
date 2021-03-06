package com.test.application.repo;

import com.test.application.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
     User findByUsername(String username);
     List<User> getAllByUsername(String username);
}
