package example.multi.connect.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class EntityManagerUtils {

    @Autowired
    @PersistenceContext(unitName="mainUnit")//связываем с DatabaseMain
    private EntityManager mainDatabase;

    @Autowired
    @PersistenceContext(unitName="secondUnit")//связываем с DatabaseSecond
    private EntityManager secondDatabase;

    @Autowired
    @PersistenceContext(unitName="thirdUnit")//связываем с DatabaseThird
    private EntityManager thirdDatabase;

    public EntityManagerUtils() {
    }

    public EntityManager getEm(String url){

        if(url.contains("main"))
            return mainDatabase;
        if(url.contains("second"))
            return secondDatabase;
        if(url.contains("third"))
            return thirdDatabase;
        return mainDatabase;
    }
    public JpaRepositoryFactory getJpaFactory(String url){
        return new JpaRepositoryFactory(getEm(url));
    }
}