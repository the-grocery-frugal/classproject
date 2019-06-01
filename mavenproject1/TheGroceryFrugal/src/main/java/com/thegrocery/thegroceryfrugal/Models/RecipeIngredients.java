package com.thegrocery.thegroceryfrugal.Models;
// Generated Jun 1, 2019 4:17:22 PM by Hibernate Tools 4.3.1



/**
 * RecipeIngredients generated by hbm2java
 */
public class RecipeIngredients  implements java.io.Serializable {


     private int id;
     private Ingredients ingredients;
     private Measurement measurement;
     private Recipe recipe;
     private Integer quantity;

    public RecipeIngredients() {
    }

	
    public RecipeIngredients(int id, Ingredients ingredients, Measurement measurement, Recipe recipe) {
        this.id = id;
        this.ingredients = ingredients;
        this.measurement = measurement;
        this.recipe = recipe;
    }
    public RecipeIngredients(int id, Ingredients ingredients, Measurement measurement, Recipe recipe, Integer quantity) {
       this.id = id;
       this.ingredients = ingredients;
       this.measurement = measurement;
       this.recipe = recipe;
       this.quantity = quantity;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Ingredients getIngredients() {
        return this.ingredients;
    }
    
    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }
    public Measurement getMeasurement() {
        return this.measurement;
    }
    
    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }
    public Recipe getRecipe() {
        return this.recipe;
    }
    
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }




}

