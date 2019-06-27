/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thegrocery.thegroceryfrugal.Models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jacob
 */
@Entity
@Table(name = "grocery_list")
public class GroceryList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private int id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users user_id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe_id;
    
    @Column(name = "title")
    private String title;

    public GroceryList() {
    }

    public GroceryList(Users user_id, Recipe recipe_id) {
        this.user_id = user_id;
        this.recipe_id = recipe_id;
        this.title = String.valueOf(this.id) + "_grocery_list";
    }

    public GroceryList(Users user_id, Recipe recipe_id, String title) {
        this.user_id = user_id;
        this.recipe_id = recipe_id;
        this.title = title;
    }

    public Users getUser_id() {
        return user_id;
    }

    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }

    public Recipe getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(Recipe recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }
    
    
    
}
