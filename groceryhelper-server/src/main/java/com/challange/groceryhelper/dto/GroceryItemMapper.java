/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challange.groceryhelper.dto;

import com.challange.groceryhelper.domain.GroceryItem;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

/**
 *
 * @author SArgade
 */
@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL)
public interface GroceryItemMapper {
    
    GroceryItemDto asGroceryItemDto(GroceryItem in);
    
    GroceryItem asGroceryItem(GroceryItemDto in,GroceryItem out);
    
}
