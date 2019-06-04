/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thegrocery.thegroceryfrugal;


import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Recipe {
    
    private List<Ingredient> ingredients;
    
    public Recipe() {
        ingredients = new ArrayList<>();
    }
    
    public void addIngredient(Product product, int quantity) {
        ingredients.add(new Ingredient(product, quantity));
    }

    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredients);
    }
    
    public boolean isEmpty() {
        return ingredients.isEmpty();
    }

    @Override
    public String toString() {
        return ingredients.toString();
    }

}
