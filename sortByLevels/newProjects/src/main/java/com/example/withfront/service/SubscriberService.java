package com.example.withfront.service;


import com.example.withfront.exception.RecordNotFoundException;
import com.example.withfront.model.Subscriber;
import com.example.withfront.repo.subscriber.SubscriberRepo;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class SubscriberService {
    private final SubscriberRepo subscriberRepo;

    public SubscriberService(SubscriberRepo subscriberRepo) {
        this.subscriberRepo = subscriberRepo;
    }


    public List<Subscriber> getAllEmployees()
        {
            List<Subscriber> result = (List<Subscriber>) subscriberRepo.findAll();
            if(result.size() > 0) {
                return result;
            } else {
                return new ArrayList<Subscriber>();
            }
        }

        public Subscriber getSubscriberById(Integer id) throws RecordNotFoundException
        {
            Optional<Subscriber> employee = subscriberRepo.findById(id);
                return employee.get();

        }

        public Subscriber createOrUpdateEmployee(Subscriber entity) throws NoSuchAlgorithmException {
                Optional<Subscriber> employee = subscriberRepo.findById(entity.getId());

                if(employee.isPresent())
                {
                    Subscriber newEntity = employee.get();
                    newEntity.setUsername(entity.getUsername());
                    newEntity.setDomain(entity.getDomain());
                    newEntity.setPassword(entity.getPassword());
                    newEntity.setHa1(getMD5(entity.getUsername()));
                    newEntity.setHa1b(getMD5(entity.getPassword()));
                    newEntity = subscriberRepo.save(newEntity);

                    return newEntity;
                } else {
                    if (subscriberRepo.findByUsername(entity.getUsername())!=null)
                    entity.setHa1(getMD5(entity.getUsername()));
                    entity.setHa1b(getMD5(entity.getPassword()));
                    entity = subscriberRepo.save(entity);

                    return entity;
                }
        }

        public void deleteEmployeeById(Integer id) throws RecordNotFoundException
        {
            Optional<Subscriber> employee = subscriberRepo.findById(id);

            if(employee.isPresent())
            {
                subscriberRepo.deleteById(id);
            } else {
                throw new RecordNotFoundException("No employee record exist for given id");
            }
        }
    public static String getMD5(String data) throws NoSuchAlgorithmException
    {
        MessageDigest messageDigest= MessageDigest.getInstance("MD5");
        messageDigest.update(data.getBytes());
        byte[] digest=messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(Integer.toHexString((int) (b & 0xff)));
        }
        return sb.toString();
    }

}

