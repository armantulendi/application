package com.project.data.repo;

import com.project.data.model.DrGateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrGatewayRepo extends JpaRepository<DrGateway,Integer> {

    DrGateway findByGwId(Integer integer);
}
