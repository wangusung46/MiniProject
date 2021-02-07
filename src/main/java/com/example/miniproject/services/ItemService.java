/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.miniproject.services;

import com.example.miniproject.model.Item;
import java.util.List;

/**
 *
 * @author 62812
 */
public interface ItemService {

    public Item getId(Long id);

    public List<Item> getPrize();

    public void decraseCount(Long id, Long itemAdd);

}
