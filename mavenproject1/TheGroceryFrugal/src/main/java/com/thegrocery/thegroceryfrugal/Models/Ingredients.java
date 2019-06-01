package com.thegrocery.thegroceryfrugal.Models;
// Generated Jun 1, 2019 4:17:22 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Ingredients generated by hbm2java
 */
public class Ingredients  implements java.io.Serializable {


     private int id;
     private String name;
     private String description;
     private Set recipeIngredientses = new HashSet(0);

    public Ingredients() {
    }

	
    public Ingredients(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Ingredients(int id, String name, String description, Set recipeIngredientses) {
       this.id = id;
       this.name = name;
       this.description = description;
       this.recipeIngredientses = recipeIngredientses;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Set getRecipeIngredientses() {
        return this.recipeIngredientses;
    }
    
    public void setRecipeIngredientses(Set recipeIngredientses) {
        this.recipeIngredientses = recipeIngredientses;
    }




}

