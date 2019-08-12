/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challange.groceryhelper.service;

import com.challange.groceryhelper.domain.GroceryItem;
import java.util.List;

/**
 *
 * @author SArgade
 */
public interface GroceryHelperService {
    
    public GroceryItem saveGroceryItem(GroceryItem groceryItem);
    
    public GroceryItem findGroceryItemByName(String groceryItemName);
    
    public List<GroceryItem> searchGroceryItemByNameOrDescription(String groceryItemName, String description,String tag );
    
    public Boolean deleteGroceryItem(Long id);
    public List<GroceryItem> findAllGroceryItems();
    public GroceryItem findGroceryItemById(Long id);
}
