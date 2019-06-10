/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thegrocery.thegroceryfrugal.Utility;

import com.thegrocery.thegroceryfrugal.HibernateUtil;
import com.thegrocery.thegroceryfrugal.Models.Categories;
import com.thegrocery.thegroceryfrugal.Models.Recipe;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jacob
 */
public class RecipeUtility {
    
    // Add a recipe to the database
    public static Integer addRecipe(String recipeName) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Integer recipeID = null;
        try {
            tx = session.beginTransaction();
            Recipe recipe = new Recipe(recipeName);
            recipeID = (Integer) session.save(recipe);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return recipeID;    
    }
    
    // Add steps to a recipe by its name
    public static boolean addSteps(String name, String steps) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Recipe recipe = null;
        boolean success = false;
        try {
            String query = "FROM Recipe where name='" + name + "'";
            recipe = (Recipe) session.createQuery(query).uniqueResult();
            recipe.setSteps(steps);
            session.update(recipe);
            tx.commit();
            success = true;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return success;
    }
    
    // Add steps to a recipe by its ID
    public static boolean addSteps(Integer recipeID, String steps) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Recipe recipe = null;
        boolean success = false;
        try {
            recipe = (Recipe)session.get(Recipe.class, recipeID);
            recipe.setSteps(steps);
            session.update(recipe);
            tx.commit();
            success = true;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return success;
    }
    
    // Add a description to a recipe by its name
    public static boolean addDescription(String name, String description) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Recipe recipe = null;
        boolean success = false;
        try {
            tx = session.beginTransaction();
            String query = "FROM Recipe where name='" + name + "'";
            recipe = (Recipe) session.createQuery(query).uniqueResult();
            recipe.setDescription(description);
            session.update(recipe);
            success = true;
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return success;
    }
    
    // Add a description to a recipe by its ID
    public static boolean addDescription(Integer RecipeID, String description) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Recipe recipe = null;
        boolean success = false;
        try {
            tx = session.beginTransaction();
            recipe = (Recipe)session.get(Recipe.class, RecipeID);
            recipe.setDescription(description);
            session.update(recipe);
            success = true;
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        } 
        
        return success;
    }
    
    public static boolean addCategory(String name, Categories category){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Recipe recipe = null;
        boolean success = false;
        try{
            tx = session.beginTransaction();
            String query = "FROM Recipe WHERE lower(name) = '" + name + "'";
            recipe = (Recipe)session.createQuery(query).uniqueResult();
            recipe.setCategories(category);
            session.update(recipe);
            success = true;
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return success;
    }
    
    // Find a recipe by its name.  This uses the LIKE operator with the WHERE
    // clause in order to allow searching for specifc terms in case the user
    // doesn't know what is available.
    public static List<Recipe> findRecipeByName(String name){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<Recipe> recipes = null;
        try {
            tx = session.beginTransaction();
            String query = "FROM Recipe WHERE lower(name) like lower('%" + name + "%')";
            recipes = session.createQuery(query).list();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return recipes;
    }
    
    // THIS IS A WIP
    public static List<Recipe> findRecipeByCategory(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<Recipe> recipes = null;
        try {
            tx = session.beginTransaction();
            
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return recipes;
    }
    
    // Find a recipe by an ingredients name.  This uses the LIKE operator with the WHERE
    // clause in order to allow searching for specifc terms in case the user
    // doesn't know what is available.
    public static List<Recipe> findRecipeByIngredientName(String ingredient){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<Recipe> recipes = null;
        try {
            tx = session.beginTransaction();
            String query = "SELECT R FROM Recipe R " + 
                            "LEFT JOIN R.recipeIngredientses RI " +
                            "LEFT JOIN RI.ingredients I " +
                            "WHERE lower(I.name) like lower('%" + ingredient + "%')";
            recipes = session.createQuery(query).list();
            
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return recipes;
    }
    
    // Simply list all recipes
    public static List<Recipe> listAllRecipes(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<Recipe> recipes = null;
        try {
            session.beginTransaction();
            String query = "FROM Recipe";
            recipes = session.createQuery(query).list();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return recipes;
    }
}
