package com.project.data.repo;

import com.project.data.model.DrRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrRulesRepo extends JpaRepository<DrRules,Integer> {

    DrRules findByRuleId(Integer integer);
}
