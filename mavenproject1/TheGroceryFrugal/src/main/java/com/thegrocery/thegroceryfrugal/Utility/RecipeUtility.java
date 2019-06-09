/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thegrocery.thegroceryfrugal.Utility;

import com.thegrocery.thegroceryfrugal.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jacob
 */
public class RecipeUtility {
    public void addRecipe(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        
        try {
            
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public void findRecipeByName(String recipe){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        
        try {
            
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public void findRecipeByCategory(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List recipes = null;
        try {
            tx = session.beginTransaction();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public List findRecipeByIngredientName(String ingredient){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List recipes = null;
        try {
            tx = session.beginTransaction();
            String query = "SELECT R FROM Recipe R " + 
                            "LEFT JOIN R.recipeIngredientses RI " +
                            "LEFT JOIN RI.ingredients I " +
                            "WHERE I.name = '" + ingredient + "'";
            recipes = session.createQuery(query).list();
            
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return recipes;
    }
    
    public List listAllRecipes(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List recipes = null;
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
    
    public void updateRecipeSteps(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        
        try {
            
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
