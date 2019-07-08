/**
 * File: GroceryList.java
 * Author: jacob
 * Date: 6/16/2019
 */
package com.thegrocery.thegroceryfrugal.Models;

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
import javax.persistence.Table;

/**
 * Represents GroceryList entity.
 *
 * @author jacob
 */
@Entity
@Table(name = "grocery_list")
public class GroceryList {

    /**
     * An auto-generated list ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    /**
     * An user ID.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users user_id;

    /**
     * A recipe ID.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe_id;

    /**
     * A title.
     */
    @Column(name = "title")
    private String title;

    /**
     * Constructs default GroceryList object.
     */
    public GroceryList() {
    }

    /**
     * Constructs an GroceryList object with the specified properties.
     *
     * @param user_id   an user ID
     * @param recipe_id a recipe ID
     */
    public GroceryList(Users user_id, Recipe recipe_id) {
        this.user_id = user_id;
        this.recipe_id = recipe_id;
        this.title = String.valueOf(this.id) + "_grocery_list";
    }

    /**
     * Constructs an GroceryList object with the specified properties.
     *
     * @param user_id   an user ID
     * @param recipe_id an recipe ID
     * @param title     a title
     */
    public GroceryList(Users user_id, Recipe recipe_id, String title) {
        this.user_id = user_id;
        this.recipe_id = recipe_id;
        this.title = title;
    }

    /**
     * Returns ID of this list.
     *
     * @return this list ID
     */
    public long getId() {
        return id;
    }

    /**
     * Returns an user ID.
     *
     * @return an user ID
     */
    public Users getUser_id() {
        return user_id;
    }

    /**
     * Sets an user ID.
     *
     * @param user_id an user ID
     */
    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }

    /**
     * Returns a recipe ID.
     *
     * @return a recipe ID
     */
    public Recipe getRecipe_id() {
        return recipe_id;
    }

    /**
     * Sets a recipe ID.
     *
     * @param recipe_id a recipe ID
     */
    public void setRecipe_id(Recipe recipe_id) {
        this.recipe_id = recipe_id;
    }

    /**
     * Returns a title.
     *
     * @return a title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets a title.
     *
     * @param title a title
     */
    public void setTitle(String title) {
        this.title = title;
    }
}