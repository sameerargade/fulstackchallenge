/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challange.groceryhelper.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SArgade
 */
@Repository("GroceryItemRepository")
public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {
 
   GroceryItem findByName(String name);   
   @Query("Select groceryItem from GroceryItem groceryItem where (?1 is null or groceryItem.name=?1) and (?2 is null or groceryItem.description=?2) and (?3 is null or groceryItem.tag=?3)" )
   List<GroceryItem> searchGroceryItem(String name, String desc,String tag); 
}
