package com.test.application;

import com.test.application.model.credit.Rate;
import com.test.application.model.credit.Term;
import com.test.application.model.user.User;
import com.test.application.repo.RateRepo;
import com.test.application.repo.TermRepo;
import com.test.application.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
class PreCreatingUser implements CommandLineRunner {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RateRepo rateRepo;
    @Autowired
    private TermRepo termRepo;
    @Override
    public void run(String... args) throws Exception {
//        проверяет есть ли дефолтный пользователь user если нет, то создает
        User user=new User();
        user.setUsername("user");
        if ( userRepo.getAllByUsername(user.getUsername()).isEmpty()) {
            //123 password
            user.setId(1);
            user.setPassword("$2y$08$WJJWhUYsSkA1yXZjEBcHoOe39FCJHyaFpgCD7t2Qk2XnHGnxoyWUa");
            userRepo.save(user);
        }
        user.setUsername("user1");
        if ( userRepo.getAllByUsername(user.getUsername()).isEmpty()) {
            user.setId(2);
            //qwer@123 password
            user.setPassword("$2y$12$VGciANZ.FWUxAn/Rg.XcI.6fXTujqti11lrr7N2ab7hIqTxa5ZX1u ");
            userRepo.save(user);
        }
        int[] rate1 ={9,10,11};
        for (int i =0; i < rate1.length; i++) {
            Rate rate=new Rate();
            if(!rateRepo.findByValue(rate1[i]).isEmpty())
                rateRepo.deleteByValue(i);
            rate.setValue(rate1[i]);
            rateRepo.save(rate);
        }

        int[] term1 ={3,6,9,12,24};
        for (int i = 0; i < term1.length; i++) {
            if(!termRepo.findByValue(term1[i]).isEmpty())
                termRepo.deleteByValue(i);
        Term term=new Term();
        term.setId(i);
        term.setValue(term1[i]);
        termRepo.save(term);
        }
}
}
