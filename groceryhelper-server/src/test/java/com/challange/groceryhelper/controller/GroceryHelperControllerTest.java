/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challange.groceryhelper.controller;

import com.challange.groceryhelper.domain.GroceryItem;
import com.challange.groceryhelper.dto.GroceryItemDto;
import com.challange.groceryhelper.service.GroceryHelperService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
//import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author SArgade
 */

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class GroceryHelperControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private GroceryHelperService groceryHelperService;

    @Test
    void getAllGroceryItems() throws Exception {
        List<GroceryItem> groceryItems = new ArrayList<>();
        groceryItems.add(new GroceryItem(1L, "Colgate", "Toothpaste"));
        groceryItems.add(new GroceryItem(2L, "Head&Shoulders", "Shampoo"));
        groceryItems.add(new GroceryItem(3L, "OralB", "ToothPaste"));
        when(groceryHelperService.findAllGroceryItems()).thenReturn(groceryItems);
        mockMvc.perform(MockMvcRequestBuilders.get("/findAllGroceryItems")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(jsonPath("$", hasSize(3))).andDo(print());
    }

    @Test
    void successfullyCreateAnItem() throws Exception {
        GroceryItem greoceryItem = new GroceryItem(4L, "Marie", "Buiscuits");
        when(groceryHelperService.saveGroceryItem(any(GroceryItem.class))).thenReturn(greoceryItem);
        ObjectMapper objectMapper = new ObjectMapper();
        String groceryItemJSON = objectMapper.writeValueAsString(greoceryItem);
        ResultActions result = mockMvc.perform(post("/saveGroceryItem")
                .contentType(MediaType.APPLICATION_JSON)
                .content(groceryItemJSON)
        );
        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Marie"))
                .andExpect(jsonPath("$.id").value(4));
    }
}
