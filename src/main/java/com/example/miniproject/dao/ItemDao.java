/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.miniproject.dao;

import com.example.miniproject.model.Item;
import com.example.miniproject.services.ItemService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 62812
 */
@Service
public class ItemDao implements ItemService {

    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Item getId(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Item.class, id);
    }

    @Override
    public List<Item> getPrize() {
        EntityManager em = emf.createEntityManager();
        @SuppressWarnings("unchecked")
        List<Item> results = em.createNativeQuery("SELECT * FROM items", Item.class).getResultList();
        System.out.println();
        return results;
    }

    @Override
    @Transactional
    public void decraseCount(Long idItem, Long itemAdd) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("UPDATE Item SET countItem = countItem - " + itemAdd + " WHERE id = " + idItem);
        int rowsUpdated = q.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        em.getTransaction().commit();
        em.close();
        System.out.println(idItem + "sasa" + itemAdd);
    }

}
