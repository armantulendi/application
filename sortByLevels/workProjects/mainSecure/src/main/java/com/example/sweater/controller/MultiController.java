//package com.example.sweater.controller;
//
//import com.example.sweater.config.multi.BookConfig;
//import com.example.sweater.domain.multi.Book;
//import com.example.sweater.domain.multi.User1;
//import com.example.sweater.repos.BookDao;
//import com.example.sweater.repos.UserDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@EnableTransactionManagement
//public class MultiController {
//    BookConfig bookConfig;
//    @Autowired
//    private UserDao userDao;
//    @Autowired
//    private BookDao bookDao;
//
//    private Book book;
//
//    @GetMapping("/user")
//    public Iterable<User1> getUser(){
//
//        return userDao.findAll();
//    }
//    @GetMapping("/book")
//    public Iterable<Book> getBook(){
//
//        return bookDao.findAll();
//    }
//    @GetMapping("/databases/view")
////    @Transactional("bookTransactionManager")
//    public String getBookView(Model model){
//
//        bookDao.findAll();
//        model.addAttribute("books",bookDao.findAll());
//        model.addAttribute("users",userDao.findAll());
//
//        return "forBook";
//    }
//
//
//    @PostMapping("/databases/view")
//    public String postMap(
//            @ModelAttribute  Book book,
//            Model model){
//        Book books = bookDao.getOne(book.getId());
//        books.setDropAddress(book.getDropAddress());
//        books.setBookingAmount(book.getBookingAmount());
//        books.setPickupAddress(book.getPickupAddress());
//        books.setCreatedBy(book.getCreatedBy());
//        bookDao.saveAndFlush(books);
//
//        return "redirect:/databases/view";
//    }
//
//    @GetMapping("/databases/user")
//    @Transactional("user1TransactionManager")
//    public String getUser(
//            @ModelAttribute User1 user1,
//            Model model ){
//        model.addAttribute("users", userDao.findAll());
//        return "forUser";
//    }
//
//    @PostMapping("/databases/user")
//    @Transactional("user1TransactionManager")
//    public String postUser(
////            @ModelAttribute User user,
//            @RequestParam("userId") Integer userId,
//            @RequestParam("userStr") String userStr,
//            Model model ){
//        User1 users = userDao.getOne(userId) ;
//        users.setUserId(userId);
//        users.setStr(userStr);
//        userDao.save(users);
//        return "redirect:/databases/view";
//    }
//
//}
