/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.miniproject.dao;

import com.example.miniproject.services.UserService;
import com.example.miniproject.model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 62812
 */
@Service
public class UserDao implements UserService {

    private EntityManagerFactory emf;
    
    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public User getId(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(User.class, id);
    }

}
