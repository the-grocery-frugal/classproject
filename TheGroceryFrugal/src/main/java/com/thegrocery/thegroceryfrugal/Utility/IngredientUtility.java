/**
 * File: IngredientUtility.java
 * Author: jacob
 * Date: 6/16/2019
 */
package com.thegrocery.thegroceryfrugal.Utility;

import com.thegrocery.thegroceryfrugal.HibernateUtil;
import com.thegrocery.thegroceryfrugal.Models.Ingredients;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Utility class to deal with "ingredients" table.
 *
 * @author jacob
 */
public class IngredientUtility {
    /**
     * Adds a new ingredient to the database.
     *
     * @param name an ingredient name
     * @return an ID of a new ingredient
     */
    public static Integer addIngredient(String name){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Integer ingredientID = null;
        
        try {
            tx = session.beginTransaction();
            Ingredients ingredient = new Ingredients(name);
            ingredientID = (Integer)session.save(ingredient);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ingredientID;
    }
    
    /**
     * Adds a description to an ingredient by its name.
     *
     * @param name        an ingredient name to search
     * @param description an ingredient description
     * @return true on success or false otherwise
     */
    public static boolean addDescription(String name, String description){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Ingredients ingredient = null;
        boolean success = false;
        
        try {
            tx = session.beginTransaction();
            String query = "FROM Ingredients WHERE name = '" + name + "'";
            ingredient = (Ingredients)session.createQuery(query).uniqueResult();
            ingredient.setDescription(description);
            success = true;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return success;
    }
    
    /**
     * Adds a description to an ingredient by its ID.
     *
     * @param ingredientID an ingredient ID to search
     * @param description  an ingredient description
     * @return true on success or false otherwise
     */
    public static boolean addDescription(Integer ingredientID, String description){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Ingredients ingredient = null;
        boolean success = false;
        
        try {
            tx = session.beginTransaction();
            ingredient = (Ingredients)session.get(Ingredients.class, ingredientID);
            ingredient.setDescription(description);
            success = true;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return success;
    }
    
    /**
     * Finds all ingredients by their name.
     *
     * @param name an ingredient name to search
     * @return a list of ingredients that match a given name
     */
    public static List<Ingredients> findIngredientsByName(String name){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<Ingredients> ingredients = null;
        try {
            tx = session.beginTransaction();
            String query = "FROM Ingredients WHERE lower(name) like lower('%" + name + "%')";
            ingredients = session.createQuery(query).list();
            
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ingredients; 
    }
    
    /**
     * Find all ingredients for all recipes with this name.
     *
     * @param name a recipe name
     * @return list of all ingredients for all recipes with this name
     */
    public static List<Ingredients> findIngredientsByRecipeName(String name){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<Ingredients> ingredients = null;
        
        try {
            tx = session.beginTransaction();
            String query = "SELECT I From Ingredients I " +
                           "LEFT JOIN I.recipeIngredientses RI " +
                           "LEFT JOIN RI.recipe R " + 
                           "WHERE lower(R.name) like lower('" + name + "')";
            ingredients = session.createQuery(query).list();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return ingredients;
    }
    
    /**
     * Finds ingredient by its name.
     *
     * @param name an ingredient  name
     * @return a Ingredients found or null if not found
     */
    public static Ingredients getIngredient(String name){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Ingredients ingredient = null;
        
        try {
            tx = session.beginTransaction();
            String query = "From Ingredients I where I.name = '" + name + "'";
            ingredient = (Ingredients)session.createQuery(query).uniqueResult();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return ingredient;
    }
    
    /**
     * Returns list of all ingredients.
     *
     * @return list of all ingredients
     */
    public static List<Ingredients> listAllIngredients(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<Ingredients> ingredients = null;
        try {
            tx = session.beginTransaction();
            String query = "FROM Ingredients";
            ingredients = session.createQuery(query).list();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return ingredients;
    }
}
