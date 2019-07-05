/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thegrocery.thegroceryfrugal.Utility;

import com.thegrocery.thegroceryfrugal.HibernateUtil;
import com.thegrocery.thegroceryfrugal.Models.Categories;
import com.thegrocery.thegroceryfrugal.Models.Recipe;
import com.thegrocery.thegroceryfrugal.Models.Users;
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
    public static Integer addRecipe(String recipeName, Users user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Integer recipeID = null;
        try {
            tx = session.beginTransaction();
            Recipe recipe = new Recipe(recipeName, user);
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
    
    public static Integer addRecipe(String recipeName, String description, Users user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Integer recipeID = null;
        try {
            tx = session.beginTransaction();
            Recipe recipe = new Recipe(recipeName,description,user);
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
    
    public static Integer addRecipe(String recipeName, String description, String steps, Users user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Integer recipeID = null;
        try {
            tx = session.beginTransaction();
            Recipe recipe = new Recipe(recipeName, description, steps, user);
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
    public static boolean changeSteps(Users user, String name, String steps) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Recipe recipe = null;
        boolean success = false;
        try {
            tx = session.beginTransaction();
            String query = "FROM Recipe where name='" + name + "' AND user_id = " + user.getId();
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
    public static boolean changeSteps(Users user, Integer recipeID, String steps) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Recipe recipe = null;
        boolean success = false;
        try {
            tx = session.beginTransaction();
            recipe = (Recipe)session.get(Recipe.class, recipeID);
            if (recipe.getUser() == user){
                recipe.setSteps(steps);
                session.update(recipe);
                tx.commit();
                success = true;
            }
            
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return success;
    }
    
    // Add a description to a recipe by its name
    public static boolean changeDescription(Users user, String name, String description) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Recipe recipe = null;
        boolean success = false;
        try {
            tx = session.beginTransaction();
            String query = "FROM Recipe where name='" + name + "' AND user_id =" + user.getId();
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
    public static boolean changeDescription(Users user, Integer RecipeID, String description) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Recipe recipe = null;
        boolean success = false;
        try {
            tx = session.beginTransaction();
            recipe = (Recipe)session.get(Recipe.class, RecipeID);
            if (recipe.getUser() == user){
                recipe.setDescription(description);
                session.update(recipe);
                success = true;
                tx.commit();
            }
            
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
    
    public static boolean changeName(String old_name, String new_name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Recipe recipe = null;
        boolean success = false;
        try {
            tx = session.beginTransaction();
            String query = "FROM Recipe where name='" + old_name + "'";
            recipe = (Recipe) session.createQuery(query).uniqueResult();
            recipe.setName(new_name);
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
    
    public static Recipe getRecipe(String recipe_name){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Recipe recipe = null;
        try {
            tx = session.beginTransaction();
            String query = "FROM Recipe R WHERE R.name = '" + recipe_name + "'";
            recipe = (Recipe)session.createQuery(query).uniqueResult();
        } catch (HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return recipe;
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
    
    public static boolean deleteRecipe(Recipe recipe, Users user){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        boolean success = false;
        if (recipe.getUser() != user){
            return success;
        }
        try {
            session.beginTransaction();
            if (RecipeIngredientUtility.deleteAllAssociations(recipe)){
                session.delete(recipe);
            }
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return success;
    }
    
    /**
     * Author: Amanda Kok
     * Gathers all recipes for userId parameter and
     * returns them.  If userId is 19, it returns all default recipes
     * @return Returns a list of all recipes associated with userId
     */
    public static List<Recipe> gatherRecipes(long id) {
        List<Recipe> gatheredRecipes = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        
        try {
            session.beginTransaction();
            String query = "FROM Recipe WHERE user_id = " + id;
            gatheredRecipes = session.createQuery(query).list();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return gatheredRecipes;
    }
    
}
