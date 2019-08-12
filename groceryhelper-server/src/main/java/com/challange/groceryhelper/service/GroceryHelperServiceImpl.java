/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challange.groceryhelper.service;

import com.challange.groceryhelper.domain.GroceryItem;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.challange.groceryhelper.domain.GroceryItemRepository;
import java.util.Optional;

/**
 *
 * @author SArgade
 */
@Service
public class GroceryHelperServiceImpl implements GroceryHelperService {

    GroceryItemRepository repository;

    @Autowired
    GroceryHelperServiceImpl(GroceryItemRepository groceryItemRepository) {
        this.repository = groceryItemRepository; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GroceryItem saveGroceryItem(GroceryItem groceryItem) {
        try {
            groceryItem = repository.save(groceryItem);
        } catch (Exception e) {
            e.printStackTrace();
            return groceryItem;
        }
        //To change body of generated methods, choose Tools | Templates.

        return groceryItem;
    }

    @Override
    public Boolean deleteGroceryItem(Long id) {
        Optional<GroceryItem> groceryItem = null;
        try {
            groceryItem = repository.findById(id);
            repository.delete(groceryItem.get());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GroceryItem findGroceryItemByName(String groceryItemName) {
        return repository.findByName(groceryItemName);
    }

    @Override
    public List<GroceryItem> findAllGroceryItems() {
        return repository.findAll();
    }

    @Override
    public List<GroceryItem> searchGroceryItemByNameOrDescription(String groceryItemName, String description,String tag) {
    return repository.searchGroceryItem(groceryItemName, description,tag);
    }

    @Override
    public GroceryItem findGroceryItemById(Long id) {
        return repository.findById(id).get(); //To change body of generated methods, choose Tools | Templates.
    }

}
