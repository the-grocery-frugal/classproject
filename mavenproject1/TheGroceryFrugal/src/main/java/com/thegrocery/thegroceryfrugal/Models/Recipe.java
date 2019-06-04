package com.thegrocery.thegroceryfrugal.Models;
// Generated Jun 4, 2019 6:31:11 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Recipe generated by hbm2java
 */
public class Recipe  implements java.io.Serializable {


     private int id;
     private Categories categories;
     private Nutrition nutrition;
     private String description;
     private String name;
     private String steps;
     private Set recipeIngredientses = new HashSet(0);

    public Recipe() {
    }

	
    public Recipe(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Recipe(int id, Categories categories, Nutrition nutrition, String description, String name, String steps, Set recipeIngredientses) {
       this.id = id;
       this.categories = categories;
       this.nutrition = nutrition;
       this.description = description;
       this.name = name;
       this.steps = steps;
       this.recipeIngredientses = recipeIngredientses;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Categories getCategories() {
        return this.categories;
    }
    
    public void setCategories(Categories categories) {
        this.categories = categories;
    }
    public Nutrition getNutrition() {
        return this.nutrition;
    }
    
    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getSteps() {
        return this.steps;
    }
    
    public void setSteps(String steps) {
        this.steps = steps;
    }
    public Set getRecipeIngredientses() {
        return this.recipeIngredientses;
    }
    
    public void setRecipeIngredientses(Set recipeIngredientses) {
        this.recipeIngredientses = recipeIngredientses;
    }




}


