/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.miniproject.services;

import com.example.miniproject.model.Booking;
import java.util.List;

/**
 *
 * @author 62812
 */
public interface BookingService {

    public Booking getId(Long id);

    public Booking saveOrUpdate(Booking booking);

    public void deleteBookingId(Long id);

    public void decrasePrize();

    public void paying(Long id);

}
