/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challange.groceryhelper.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author SArgade
 */
@Entity
@Table(name = "grocery_item")
public class GroceryItem {

   

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;
    //private Long brandID;
    
    @Column(name = "item_name", nullable = false,unique=true)
    private String name;
    @Column(name = "item_description", nullable = false)
    private String description;

    @Column(name = "item_category", nullable = false)
    private String tag;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    public GroceryItem(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
     public GroceryItem() {
    }

    /**
     * @return the brandID
     */
//    public Long getBrandID() {
//        return brandID;
//    }
//
//    /**
//     * @param brandID the brandID to set
//     */
//    public void setBrandID(Long brandID) {
//        this.brandID = brandID;
//    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

}
