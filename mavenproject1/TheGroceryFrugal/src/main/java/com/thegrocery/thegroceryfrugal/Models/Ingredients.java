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



@Entity
@Table(name = "ingredients")
public class Ingredients  implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable=false, unique=true)
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @OneToMany(mappedBy = "ingredients")
    private Set<RecipeIngredients> recipeIngredientses = new HashSet(0);

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

     @Override
    public String toString() {
        if (this.description != null){
            return String.valueOf(this.getId()) + " " + this.getName() + " " + this.getDescription();
        } else {
            return String.valueOf(this.getId()) + " " + this.getName();
        }
         
    }


}


