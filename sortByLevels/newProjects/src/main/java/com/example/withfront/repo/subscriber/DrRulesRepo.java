package com.example.withfront.repo.subscriber;

import com.example.withfront.model.DrRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrRulesRepo extends JpaRepository<DrRules,Integer> {

    List<DrRules> findAllByDescription(String str);

    DrRules findByRuleId(Integer integer);
}
