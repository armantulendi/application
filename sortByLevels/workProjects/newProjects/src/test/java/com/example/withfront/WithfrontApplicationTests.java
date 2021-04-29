//package com.example.withfront;
//
//import com.example.withfront.model.Book;
//import com.example.withfront.model.DrRules;
//import com.example.withfront.model.Subscriber;
//import com.example.withfront.model.User;
//import com.example.withfront.repo.book.BookDao;
//import com.example.withfront.repo.subscriber.DrRulesRepo;
//import com.example.withfront.repo.subscriber.SubscriberRepo;
//import com.example.withfront.repo.user.UserRepo;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes=WithfrontApplication.class)
//@EnableTransactionManagement
//class WithfrontApplicationTests {
//    @Autowired
//    SubscriberRepo subscriberRepo;
//    @Autowired
//    BookDao bookDao;
//    @Autowired
//    DrRulesRepo drRulesRepo;
//    @Autowired
//    UserRepo userRepo;
//
//    @Test
//    void contextLoads() {
//    }
////    data2 table 1
//    @Test
//    public void whenCreateSubscriber(){
//        Optional<Subscriber> subscribers= subscriberRepo.findById(1);
//        System.out.println(subscribers.isPresent());
//    }
////    data1 table 1
//    @Test
//    public void whenCreateBook(){
//        Iterable<Book> books= bookDao.findAll();
//        System.out.println(books);
//    }
////    data2 table 2
//    @Test
//    public void whenDr(){
//        Iterable<DrRules> drRules= drRulesRepo.findAll();
//        System.out.println(drRules);
//    }
//    @Test
//    @Transactional
//    public void whenUser(){
//        Iterable<User> drRules= userRepo.findAll();
//    }
//
//}
