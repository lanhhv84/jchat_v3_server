package com.example.jchat_v3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class IService<T, DB extends JpaRepository<T, Integer>> {
    @Autowired
    DB db;

    public void add(T obj) {
        db.save(obj);
    }
    public void delete(T obj) { db.delete(obj); }
    public void delete(int id) { db.deleteById(id); }
    public T findOne(int id) { return db.getOne(id); }
    public List<T> findAll() {
        return db.findAll();
    }
    public boolean exists(int id) {return db.existsById(id); }
}
