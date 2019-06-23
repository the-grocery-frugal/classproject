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
 * Measurement generated by hbm2java
 */

@Entity
@Table(name = "measurement")
public class Measurement  implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "measurement")
    private Set<RecipeIngredients> recipeIngredientses = new HashSet(0);

    public Measurement() {
    }
    
    public Measurement(String name){
        this.name = name;
    }
	
    public Measurement(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Measurement(int id, String name, Set recipeIngredientses) {
       this.id = id;
       this.name = name;
       this.recipeIngredientses = recipeIngredientses;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name.substring(0, 1).toUpperCase() + this.name.substring(1);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set getRecipeIngredientses() {
        return this.recipeIngredientses;
    }
    
    public void setRecipeIngredientses(Set recipeIngredientses) {
        this.recipeIngredientses = recipeIngredientses;
    }

    public void addRecipeIngredients(RecipeIngredients recipeIngredients){
        recipeIngredientses.add(recipeIngredients);
        recipeIngredients.setMeasurement(this);
    }
    
    public void removeRecipeIngredients(RecipeIngredients recipeIngredients){
        recipeIngredientses.remove(recipeIngredients);
        recipeIngredients.setMeasurement(null);
    }


}


