/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challange.groceryhelper.dto;

/**
 *
 * @author SArgade
 */
public class GroceryItemDto {

    private Long id;
    private String name;
    private String description;

    public GroceryItemDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public GroceryItemDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
