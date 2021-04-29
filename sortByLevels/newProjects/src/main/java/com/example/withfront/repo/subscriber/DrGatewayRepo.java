package com.example.withfront.repo.subscriber;

import com.example.withfront.model.DrGateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrGatewayRepo extends JpaRepository<DrGateway,Integer> {

    List<DrGateway> findAllByAttrs(String str);

    DrGateway findByGwId(Integer integer);
}
