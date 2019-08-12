/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challange.groceryhelper.contoller;

import com.challange.groceryhelper.domain.GroceryItem;
import com.challange.groceryhelper.dto.GroceryItemMapper;
import com.challange.groceryhelper.dto.SearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.challange.groceryhelper.service.GroceryHelperService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author SArgade
 */
@RestController
public class GroceryHelperController {

    @Autowired
    GroceryHelperService groceryItemService;

//    @Autowired
//    GroceryItemMapper groceryItemMapper;
    @GetMapping("/findAllGroceryItems")
    public ResponseEntity<List<GroceryItem>> index() {
        List<GroceryItem> groceryItems = groceryItemService.findAllGroceryItems();
        return new ResponseEntity(groceryItems, HttpStatus.OK);
    }
    
     @GetMapping("/deleteGroceryItem/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
       Boolean result = groceryItemService.deleteGroceryItem(id);
       if(result)
        return new ResponseEntity(result, HttpStatus.OK);
       return new ResponseEntity(result, HttpStatus.EXPECTATION_FAILED);
    }
     @GetMapping("/getGroceryItem/{id}")
    public ResponseEntity getGroceryItem(@PathVariable("id") Long id) {
       GroceryItem result = groceryItemService.findGroceryItemById(id);
       return new ResponseEntity(result, HttpStatus.OK);
      
    }

    @RequestMapping(value = "/saveGroceryItem", method = RequestMethod.POST)
    public ResponseEntity saveGroceryItem(@RequestBody GroceryItem groceryItem) {

        GroceryItem result = groceryItemService.saveGroceryItem(groceryItem);

        return new ResponseEntity(result, HttpStatus.CREATED);

        //return new ResponseEntity("",HttpStatus.EXPECTATION_FAILED);
    }

    @RequestMapping(value = "/saveTagGroceryItem", method = RequestMethod.POST)
    public ResponseEntity saveTagGroceryItem(@RequestBody GroceryItem groceryItem) {

        GroceryItem result = groceryItemService.saveGroceryItem(groceryItem);

        return new ResponseEntity(result, HttpStatus.CREATED);

        //return new ResponseEntity("",HttpStatus.EXPECTATION_FAILED);
    }
    @RequestMapping(value = "/findGroceryItemByName/{name}", method = RequestMethod.POST)
    public ResponseEntity findGroceryItemByName(@PathVariable("name") String groceryItemName) {
        try {
            GroceryItem groceryItem = groceryItemService.findGroceryItemByName(groceryItemName);

            return new ResponseEntity(groceryItem, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity("", HttpStatus.EXPECTATION_FAILED);
    }
    
    @RequestMapping(value = "/searchForGroceryItem", method = RequestMethod.POST)
    public ResponseEntity findGroceryItemByName(@RequestBody SearchDto searchDto) {
        try {
            List<GroceryItem> results = groceryItemService.searchGroceryItemByNameOrDescription(searchDto.getName(),searchDto.getDescription(),searchDto.getTag());

            return new ResponseEntity(results, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity("", HttpStatus.EXPECTATION_FAILED);
    }
    
    
}
