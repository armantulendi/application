package com.example.rulescontrol.service;


import com.example.rulescontrol.model.Subscriber;
import com.example.rulescontrol.repo.SubscriberRepo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public class SubscriberService {
    private final SubscriberRepo subscriberDao;

    public SubscriberService(SubscriberRepo subscriberDao) {
        this.subscriberDao = subscriberDao;
    }


    public <S extends Subscriber> S save(S s) {
        return null;
    }


    public <S extends Subscriber> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }


    public Optional<Subscriber> findById(int id) {
        return subscriberDao.findById(id);
    }


    public Iterable<Subscriber> findByFilter(String filter) {
        return null;
    }


    public boolean existsById(Long aLong) {
        return false;
    }


    public Iterable<Subscriber> findAll() {
        return null;
    }


    public Iterable<Subscriber> findAllById(Iterable<Long> iterable) {
        return null;
    }


    public long count() {
        return 0;
    }


    public void deleteById(Long aLong) {

    }

    public  String getMd(String data) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        messageDigest.update(data.getBytes());
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(Integer.toHexString((int) (b & 0xff)));
        }
        return sb.toString();

    }
    public void delete(Subscriber subscriber) {

    }


    public void deleteAll(Iterable<? extends Subscriber> iterable) {

    }


    public void deleteAll() {

    }
}
