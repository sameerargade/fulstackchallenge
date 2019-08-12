/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challange.groceryhelper.service;

import com.challange.groceryhelper.domain.GroceryItem;
import com.challange.groceryhelper.domain.GroceryItemRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author SArgade
 */
//@SpringBootTest
@ExtendWith(SpringExtension.class)
//@SpringBootTest
public class GroceryHelperServiceTest {

    //@Autowired
    //@Autowired
    @MockBean
    GroceryItemRepository groceryItemRepository;

    List<GroceryItem> groceryItems;
    GroceryItem groceryItem;
    GroceryHelperService groceryHelperService;

    @BeforeEach
    void initSetup() {

        groceryItem = new GroceryItem(4L, "Horlics", "Energy");
        groceryHelperService = new GroceryHelperServiceImpl(groceryItemRepository);
        when(groceryItemRepository.save(any(GroceryItem.class))).thenReturn(groceryItem);

    }

    @Test
    void getAllGroceryItems() {
        List<GroceryItem> groceryItems = new ArrayList<>();
        groceryItems.add(new GroceryItem(1L, "Colgate", "Toothpaste"));
        groceryItems.add(new GroceryItem(2L, "Head&Shoulders", "Shampoo"));
        groceryItems.add(new GroceryItem(3L, "OralB", "ToothPaste"));
        when(groceryItemRepository.findAll()).thenReturn(groceryItems);
        List<GroceryItem> returnedGroceryItems = groceryHelperService.findAllGroceryItems();
        assertEquals(returnedGroceryItems.get(0).getName(), groceryItems.get(0).getName());
        assertEquals(returnedGroceryItems.get(0).getId(), groceryItems.get(0).getId());
    }

    @Test
    void saveAGroceryItem() {
        GroceryItem createdGroceryItem = groceryHelperService.saveGroceryItem(groceryItem);

        assertThat(createdGroceryItem.getName()).isNotNull();

    }

    @Test
    void deleteAGroceryItem() {
       groceryItem = groceryItemRepository.save(groceryItem);
       Optional<GroceryItem> optionalGroceryItem = Optional.of((GroceryItem) groceryItem);
        when(groceryItemRepository.findById(groceryItem.getId())).thenReturn(optionalGroceryItem);
        groceryHelperService.deleteGroceryItem(groceryItem.getId());
        verify(groceryItemRepository, times(1)).delete(groceryItem);

    }

    @Test
    void findAGroceryItem() {

        GroceryItem createdGroceryItem = groceryHelperService.saveGroceryItem(groceryItem);
        when(groceryItemRepository.findByName(any(String.class))).thenReturn(groceryItem);

        GroceryItem foundOneGroceryItem = groceryHelperService.findGroceryItemByName(createdGroceryItem.getName());
        assertThat(foundOneGroceryItem.getName()).isNotNull();

    }

    @Test
    void updateAGroceryItem() {
        GroceryItem groceryItem = new GroceryItem(2L, "Coke", "Soft Drink");
//        GroceryHelperService groceryHelperService;
//        groceryHelperService = new GroceryHelperServiceImpl(groceryItemRepository);
        //groceryItem = groceryItemRepository.save(groceryItem);
//        when(groceryItemRepository.save(any(GroceryItem.class))).thenReturn(groceryItem);
        groceryItem = groceryHelperService.saveGroceryItem(groceryItem);

        groceryItem.setName("Pepsi");

        when(groceryItemRepository.save(any(GroceryItem.class))).thenReturn(groceryItem);
        GroceryItem updatedGroceryItem = groceryHelperService.saveGroceryItem(groceryItem);

        assertThat(updatedGroceryItem.getName()).isSameAs(groceryItem.getName());

    }

   // @Test
    void searchAGroceryItem() {

//       // GroceryItem createdGroceryItem = groceryHelperService.saveGroceryItem(groceryItem);
//        List savedGroceryItems = new ArrayList<GroceryItem>();
//        for (GroceryItem groceryItem : groceryItems) {
//            savedGroceryItems.add(groceryHelperService.saveGroceryItem(groceryItem));
//        }
//        when(groceryItemRepository.searchGroceryItem(any(String.class), any(String.class))).thenReturn(savedGroceryItems.stream()
//  .filter(filteredItem ->filteredItem.get() > 100)
//  .collect(Collectors.toList()));

    }
//    @AfterEach
//    void tearDown(){
//        groceryItemRepository.deleteAll();
//    }
}
