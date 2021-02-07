/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.miniproject.services;

import com.example.miniproject.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 62812
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

    public Object findById(Integer id);

}
