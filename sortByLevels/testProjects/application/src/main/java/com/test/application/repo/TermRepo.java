package com.test.application.repo;

import com.test.application.model.credit.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TermRepo extends JpaRepository<Term,Integer> {

    List<Term> findAllByValueIsIn(List<Integer> iterable);
}
