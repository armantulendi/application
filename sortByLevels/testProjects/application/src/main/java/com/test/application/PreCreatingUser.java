package com.test.application;

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

@Component
class PreCreatingUser implements CommandLineRunner {
    @Autowired
    private UserRepo userRepo;
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

    }
}
