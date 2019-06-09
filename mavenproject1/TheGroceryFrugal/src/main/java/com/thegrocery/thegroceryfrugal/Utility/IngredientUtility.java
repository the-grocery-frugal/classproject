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
    public void addIngredient(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try {
            
        } catch (HibernateException e) {
            
        } finally {
            session.close();
        }
    }
    
    public void listIngredients(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try {
            
        } catch (HibernateException e) {
            
        } finally {
            session.close();
        }
    }
    
    public List searchIngredients(String ingredientName){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List ingredients = null;
        try {
            tx = session.beginTransaction();
            String query = "FROM Ingredients I WHERE I.name = '" + ingredientName + "'";
            ingredients = session.createQuery(query).list();
            
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ingredients; 
    }
    
    public List listAllIngredientsForRecipe(String recipe){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List ingredients = null;
        
        try {
            tx = session.beginTransaction();
            String query = "SELECT I From Ingredients I " +
                           "LEFT JOIN I.recipeIngredientses RI " +
                           "LEFT JOIN RI.recipe R " + 
                           "WHERE R.name = 'Banana Berry Smoothie'";
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
