package com.thegrocery.thegroceryfrugal.Models;
// Generated Jun 1, 2019 9:08:50 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Nutrition generated by hbm2java
 */
public class Nutrition  implements java.io.Serializable {


     private long id;
     private String calories;
     private String caloriesFat;
     private String cholesterol;
     private String saturatedFat;
     private String totalFat;
     private String transFat;
     private String sodium;
     private String totalCarb;
     private String dietaryFib;
     private String sugars;
     private String protein;
     private Set recipes = new HashSet(0);

    public Nutrition() {
    }

	
    public Nutrition(long id) {
        this.id = id;
    }
    public Nutrition(long id, String calories, String caloriesFat, String cholesterol, String saturatedFat, String totalFat, String transFat, String sodium, String totalCarb, String dietaryFib, String sugars, String protein, Set recipes) {
       this.id = id;
       this.calories = calories;
       this.caloriesFat = caloriesFat;
       this.cholesterol = cholesterol;
       this.saturatedFat = saturatedFat;
       this.totalFat = totalFat;
       this.transFat = transFat;
       this.sodium = sodium;
       this.totalCarb = totalCarb;
       this.dietaryFib = dietaryFib;
       this.sugars = sugars;
       this.protein = protein;
       this.recipes = recipes;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public String getCalories() {
        return this.calories;
    }
    
    public void setCalories(String calories) {
        this.calories = calories;
    }
    public String getCaloriesFat() {
        return this.caloriesFat;
    }
    
    public void setCaloriesFat(String caloriesFat) {
        this.caloriesFat = caloriesFat;
    }
    public String getCholesterol() {
        return this.cholesterol;
    }
    
    public void setCholesterol(String cholesterol) {
        this.cholesterol = cholesterol;
    }
    public String getSaturatedFat() {
        return this.saturatedFat;
    }
    
    public void setSaturatedFat(String saturatedFat) {
        this.saturatedFat = saturatedFat;
    }
    public String getTotalFat() {
        return this.totalFat;
    }
    
    public void setTotalFat(String totalFat) {
        this.totalFat = totalFat;
    }
    public String getTransFat() {
        return this.transFat;
    }
    
    public void setTransFat(String transFat) {
        this.transFat = transFat;
    }
    public String getSodium() {
        return this.sodium;
    }
    
    public void setSodium(String sodium) {
        this.sodium = sodium;
    }
    public String getTotalCarb() {
        return this.totalCarb;
    }
    
    public void setTotalCarb(String totalCarb) {
        this.totalCarb = totalCarb;
    }
    public String getDietaryFib() {
        return this.dietaryFib;
    }
    
    public void setDietaryFib(String dietaryFib) {
        this.dietaryFib = dietaryFib;
    }
    public String getSugars() {
        return this.sugars;
    }
    
    public void setSugars(String sugars) {
        this.sugars = sugars;
    }
    public String getProtein() {
        return this.protein;
    }
    
    public void setProtein(String protein) {
        this.protein = protein;
    }
    public Set getRecipes() {
        return this.recipes;
    }
    
    public void setRecipes(Set recipes) {
        this.recipes = recipes;
    }




}


