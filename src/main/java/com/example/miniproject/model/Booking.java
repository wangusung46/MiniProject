/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.miniproject.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author 62812
 */
@Entity
@Table(name = "booking")
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 6)
    private Long id;

    @Column(nullable = false, length = 6)
    private Long idItem;

    @Column(nullable = false, length = 6)
    private Long idUser;

    @Column(nullable = false, length = 6)
    private Long itemAdd;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dateAdd;

    @Column(nullable = true, length = 6)
    private Long prizeBooking;

    @Column(nullable = true, length = 6)
    private Long prizeAll;
    
    @Column(columnDefinition = "integer DEFAULT 0")
    private Integer paying;

    public Integer getPaying() {
        return paying;
    }

    public void setPaying(Integer paying) {
        this.paying = paying;
    }

    public Long getPrizeAll() {
//        prizeAll = prizeBooking * itemAdd;
        return prizeAll;
    }

    public Long getPrizeBooking() {
        return prizeBooking;
    }

    public void setPrizeBooking(Long prizeBooking) {
        this.prizeBooking = prizeBooking;
    }

    public void setPrizeAll(Long prizeAll) {
        this.prizeAll = prizeAll;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getItemAdd() {
        return itemAdd;
    }

    public void setItemAdd(Long itemAdd) {
        this.itemAdd = itemAdd;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

}
