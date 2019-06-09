package com.thegrocery.thegroceryfrugal.Models;
// Generated Jun 4, 2019 6:31:11 AM by Hibernate Tools 4.3.1

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;




/**
 * RecipeIngredients generated by hbm2java
 */

@Entity
@Table(name = "recipe_ingredients")
public class RecipeIngredients  implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable=false, unique=true)
    private int id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredients_id")
    private Ingredients ingredients;
    private Measurement measurement;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
    private Float quantity;
    private String description;

    public RecipeIngredients() {
    }

	
    public RecipeIngredients(int id, Ingredients ingredients, Measurement measurement, Recipe recipe) {
        this.id = id;
        this.ingredients = ingredients;
        this.measurement = measurement;
        this.recipe = recipe;
    }
    public RecipeIngredients(int id, Ingredients ingredients, Measurement measurement, Recipe recipe, Float quantity, String description) {
       this.id = id;
       this.ingredients = ingredients;
       this.measurement = measurement;
       this.recipe = recipe;
       this.quantity = quantity;
       this.description = description;
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
    public Float getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }




}


