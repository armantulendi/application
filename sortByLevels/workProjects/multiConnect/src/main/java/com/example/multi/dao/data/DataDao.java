package com.example.multi.dao.data;

import com.example.multi.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataDao extends JpaRepository<Data,Integer> {
}
