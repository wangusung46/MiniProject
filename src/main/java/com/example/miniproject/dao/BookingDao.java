/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.miniproject.dao;

import com.example.miniproject.model.Booking;
import com.example.miniproject.services.BookingService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 62812
 */
@Service
public class BookingDao implements BookingService {

    private EntityManagerFactory emf;

    @Autowired
    private BookingService bookingRepo;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Booking getId(Long id) {
        EntityManager em = emf.createEntityManager();
//        Query query = em.createNativeQuery("UPDATE booking SET prize_all = item_add * prize_booking");
//        em.getTransaction().begin();
//        em.getTransaction().commit();
//        em.flush();
//        em.clear();
//        em.close();
//        query.executeUpdate();
        return em.find(Booking.class, id);

    }

    @Override
    public Booking saveOrUpdate(Booking booking) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Booking saved = em.merge(booking);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public void deleteBookingId(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Booking.class, id));
        em.getTransaction().commit();
    }

    @Override
    @Transactional
    public void decrasePrize() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE Booking SET prizeAll = itemAdd * prizeBooking");
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        em.getTransaction().commit();
        em.close();
    }

    

    @Override
    public void paying(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE Booking SET paying = 1 WHERE id = " + id);
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        em.getTransaction().commit();
        em.close();
    }

}
