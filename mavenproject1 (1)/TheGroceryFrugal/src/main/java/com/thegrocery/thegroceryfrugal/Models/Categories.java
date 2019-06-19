package com.thegrocery.thegroceryfrugal.Models;
// Generated Jun 4, 2019 6:31:11 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Categories generated by hbm2java
 */

@Entity
@Table(name = "categories")
public class Categories  implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false, unique=true)
    private int id;
    
    @Column(name = "description")
    private String description;
    
    @OneToMany(mappedBy = "categories")
    private Set<Recipe> recipes = new HashSet(0);

    public Categories() {
    }

	
    public Categories(int id) {
        this.id = id;
    }
    public Categories(int id, String description, Set recipes) {
       this.id = id;
       this.description = description;
       this.recipes = recipes;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Set getRecipes() {
        return this.recipes;
    }
    
    public void setRecipes(Set recipes) {
        this.recipes = recipes;
    }
    
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        recipe.setCategories(this);
    }
    
    public void removeRecipe(Recipe recipe) {
        recipes.remove(recipe);
        recipe.setCategories(null);
    }



}


