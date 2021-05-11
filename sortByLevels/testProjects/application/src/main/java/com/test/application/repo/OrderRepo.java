package com.test.application.repo;

import com.test.application.model.user.Customer;
import com.test.application.model.user.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Orders,Integer> {
    List<Orders> findByIin(String filter);
    List<Orders> getByUserId(Integer integer);
}
