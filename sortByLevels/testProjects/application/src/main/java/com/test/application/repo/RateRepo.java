package com.test.application.repo;

import com.test.application.model.credit.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateRepo extends JpaRepository<Rate,Integer> {

    void deleteByValue(Integer integer);

    List<Rate> findByValue(int value);
}
