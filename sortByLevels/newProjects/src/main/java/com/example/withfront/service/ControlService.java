package com.example.withfront.service;

import com.example.withfront.model.DrGateway;
import com.example.withfront.repo.subscriber.DrGatewayRepo;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
public class ControlService {
    private final DrGatewayRepo drGatewayRepo;
    public ControlService(DrGatewayRepo drGatewayRepo){

        this.drGatewayRepo = drGatewayRepo;
    }
    public void addGateway(DrGateway drGateway, BindingResult bindingResult) {
        Optional<DrGateway> drGateways = drGatewayRepo.findById(drGateway.getGwId());
        if (drGateways.isPresent()){
            DrGateway newDrGateway=drGateways.get();
            newDrGateway.setAttrs(drGateway.getAttrs());
            newDrGateway.setDescription(drGateway.getDescription());
            newDrGateway.setGwAddress(drGateway.getGwAddress());
            newDrGateway.setStrip(drGateway.getStrip());
            newDrGateway.setPriPrefix(drGateway.getPriPrefix());
            newDrGateway.setType(drGateway.getType());
            drGatewayRepo.save(newDrGateway);
        }else{
            drGatewayRepo.save(drGateway);
        }
    }
}
