package com.example.withfront.service;

import com.example.withfront.model.Dialplan;
import com.example.withfront.model.DrGateway;
import com.example.withfront.repo.subscriber.DialplanRepo;
import com.example.withfront.repo.subscriber.DrGatewayRepo;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
public class ControlService {
    private final DialplanRepo dialplanRepo;
    private final DrGatewayRepo drGatewayRepo;
    public ControlService(DrGatewayRepo drGatewayRepo, DialplanRepo dialplanRepo){

        this.drGatewayRepo = drGatewayRepo;
        this.dialplanRepo = dialplanRepo;
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
    public void addDiaplan(Dialplan dialplan, BindingResult bindingResult) {
        Optional<Dialplan> dialplans = dialplanRepo.findById(dialplan.getId());
        if (dialplans.isPresent()){
            Dialplan newDialplan =dialplans.get();
            newDialplan.setMatchExp(dialplan.getMatchExp());
            newDialplan.setReplExp(dialplan.getReplExp());
            newDialplan.setAttrs(dialplan.getAttrs());
            newDialplan.setMatchLen(dialplan.getMatchLen());
            newDialplan.setDpId(1);
            newDialplan.setPr(1);
            newDialplan.setMatchOp(0);
            dialplan.setSubstExp("");
            dialplanRepo.save(newDialplan);
        }else{
            dialplan.setDpId(1);
            dialplan.setPr(1);
            dialplan.setMatchOp(0);
            dialplan.setSubstExp("");
            dialplanRepo.save(dialplan);
        }
    }
}
