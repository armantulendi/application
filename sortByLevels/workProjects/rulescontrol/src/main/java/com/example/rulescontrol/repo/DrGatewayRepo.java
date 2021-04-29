package com.example.rulescontrol.repo;

import com.example.rulescontrol.model.DrGateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrGatewayRepo extends JpaRepository<DrGateway,Integer> {

    DrGateway findByGwId(Integer integer);
}
