/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thegrocery.thegroceryfrugal.Utility;

import com.thegrocery.thegroceryfrugal.HibernateUtil;
import com.thegrocery.thegroceryfrugal.Models.Ingredients;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jacob
 */
public class IngredientUtility {
    // Add an ingredient to the database
    public Integer addIngredient(String name){
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
    
    // Add a description to an ingredient by its name
    public boolean addDescription(String name, String description){
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
    
    // Add a description to an ingredient by its ID
    public boolean addDescription(Integer ingredientID, String description){
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
    
    // Find all ingredients by their name
    public List<Ingredients> findIngredientsByName(String name){
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
    
    // Find all ingredients for all recipes with this name.  This will bring back
    // a lot depending on how accruate the search is
    public List<Ingredients> findIngredientsByRecipeName(String name){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<Ingredients> ingredients = null;
        
        try {
            tx = session.beginTransaction();
            String query = "SELECT I From Ingredients I " +
                           "LEFT JOIN I.recipeIngredientses RI " +
                           "LEFT JOIN RI.recipe R " + 
                           "WHERE lower(R.name) like lower('%" + name + "%')";
            ingredients = session.createQuery(query).list();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return ingredients;
    }
    
    // This will bring back all ingredients for the specific recipe name.  The
    // name value has to be specific and accurate
    public List<Ingredients> findIngredientsBySpecificRecipeName(String name){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<Ingredients> ingredients = null;
        
        try {
            tx = session.beginTransaction();
            String query = "SELECT I From Ingredients I " +
                           "LEFT JOIN I.recipeIngredientses RI " +
                           "LEFT JOIN RI.recipe R " + 
                           "WHERE lower(R.name) = lower('%" + name + "%')";
            ingredients = session.createQuery(query).list();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return ingredients;
    }
    
    // List all ingredients
    public List<Ingredients> listAllIngredients(){
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
