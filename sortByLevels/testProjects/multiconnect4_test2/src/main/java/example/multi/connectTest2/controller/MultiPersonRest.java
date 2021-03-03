package example.multi.connectTest2.controller;

import example.multi.connectTest2.model.person.Person;
import example.multi.connectTest2.repo.person.PersonRepo;
//import example.multi.connectTest2.utils.EntityManagerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


@RestController
@RequestMapping(value = "/multiperson")
public class MultiPersonRest {

    @Autowired
    private PersonRepo repository;

    @Autowired
    private HttpServletRequest context;

    @Autowired
//    private EntityManagerUtils emUtils;


    @RequestMapping(value = "/all")
    public Iterable getAll(){
//        setRepository( context.getRequestURL().toString() );
        return repository.findAll();
    }
    @RequestMapping(value = "/single/{id}")
    public Optional<Person> getSingle(@PathVariable("id") Long id){
//        setRepository( context.getRequestURL().toString() );
        return repository.findById(id);
    }
//    private void setRepository(String url){
//        repository = emUtils.getJpaFactory(url).getRepository(PersonRepo.class);
//    }
}