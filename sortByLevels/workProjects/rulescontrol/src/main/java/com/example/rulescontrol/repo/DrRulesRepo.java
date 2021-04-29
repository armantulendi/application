package com.example.rulescontrol.repo;

import com.example.rulescontrol.model.DrRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrRulesRepo extends JpaRepository<DrRules,Integer> {

    DrRules findByRuleId(Integer integer);
}
