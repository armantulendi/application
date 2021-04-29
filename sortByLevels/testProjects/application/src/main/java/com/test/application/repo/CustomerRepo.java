package com.test.application.repo;

import com.test.application.model.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    List<Customer> findByIin(String filter);

    List<Customer> getByUserId(Integer integer);
}
