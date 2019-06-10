package com.thegrocery.thegroceryfrugal.Models;
// Generated Jun 4, 2019 6:31:11 AM by Hibernate Tools 4.3.1


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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Recipe generated by hbm2java
 */

@Entity
@Table(name = "recipe")
public class Recipe  implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private int id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Categories categories;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nutrition_id", referencedColumnName = "id")
    private Nutrition nutrition;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "steps")
    private String steps;
    
    @OneToMany(mappedBy = "recipe")
    private Set<RecipeIngredients> recipeIngredientses = new HashSet(0);

    public Recipe() {
        
    }
    
    public Recipe(String name) {
        this.name = name;
    }
    
    public Recipe(String name, Categories category, String description, String steps) {
        this.name = name;
        this.categories = category;
        this.description = description;
        this.steps = steps;
    }
    
    
    public Recipe(Categories categories, Nutrition nutrition, String description, String name, String steps, Set recipeIngredientses) {
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
    
    public void addRecipeIngredients(RecipeIngredients recipeIngredients) {
        recipeIngredientses.add(recipeIngredients);
        recipeIngredients.setRecipe(this);
    }
    
    public void removeRecipeIngredients(RecipeIngredients recipeIngredients) {
        recipeIngredientses.remove(recipeIngredients);
        recipeIngredients.setRecipe(null);
    }
    


}

