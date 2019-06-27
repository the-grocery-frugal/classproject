/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thegrocery.thegroceryfrugal.Utility;

import com.thegrocery.thegroceryfrugal.HibernateUtil;
import com.thegrocery.thegroceryfrugal.Models.Ingredients;
import com.thegrocery.thegroceryfrugal.Models.Measurement;
import com.thegrocery.thegroceryfrugal.Models.Recipe;
import com.thegrocery.thegroceryfrugal.Models.RecipeIngredients;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jacob
 */
public class RecipeIngredientUtility {
    public static Integer associateIngredientToRecipe(Recipe recipe, Ingredients ingredient, Measurement measurement){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        RecipeIngredients recipeIngredients = null;
        Integer recipeIngredientID = null;
        
        try {
            tx = session.beginTransaction();
            recipeIngredients = new RecipeIngredients(ingredient, measurement, recipe);
            recipeIngredientID = (Integer)session.save(recipeIngredients);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return recipeIngredientID;
    }
    
    public static Integer associateIngredientToRecipe(Recipe recipe, Ingredients ingredient, Measurement measurement, Float quantity){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        RecipeIngredients recipeIngredients = null;
        Integer recipeIngredientID = null;
        
        try {
            tx = session.beginTransaction();
            recipeIngredients = new RecipeIngredients(ingredient, measurement, recipe, quantity);
            recipeIngredientID = (Integer)session.save(recipeIngredients);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return recipeIngredientID;
    }
    
    public static Integer associateIngredientToRecipe(Recipe recipe, Ingredients ingredient, Measurement measurement, Float quantity, String description){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        RecipeIngredients recipeIngredients = null;
        Integer recipeIngredientID = null;
        
        try {
            tx = session.beginTransaction();
            recipeIngredients = new RecipeIngredients(ingredient, measurement, recipe, quantity, description);
            recipeIngredientID = (Integer)session.save(recipeIngredients);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return recipeIngredientID;
    }
    
    
    public static boolean changeQuantity(Integer ingredient_id, Integer recipe_id, Float quantity){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        RecipeIngredients recipeIngredients = null;
        boolean success = false;
        try{
            tx = session.beginTransaction();
            String query = "FROM RecipeIngredients WHERE ingredients_id = " + ingredient_id + " and recipe_id = " + recipe_id;
            recipeIngredients = (RecipeIngredients)session.createQuery(query).uniqueResult();
            recipeIngredients.setQuantity(quantity);
            session.update(recipeIngredients);
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
    
    public static boolean changeQuantity(String ingredient_name, String recipe_name, Float quantity){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Recipe recipe = null;
        Ingredients ingredient = null;
        RecipeIngredients recipeIngredients = null;
        boolean success = false;
        try{
            tx = session.beginTransaction();
            String recipe_query = "FROM Recipe WHERE lower(name) = lower('" + recipe_name + "')";
            recipe = (Recipe)session.createQuery(recipe_query).uniqueResult();
            String ingredient_query = "FROM Ingredients WHERE lower(name) = lower('" + ingredient_name + "')";
            ingredient = (Ingredients)session.createQuery(ingredient_query).uniqueResult();
            String query = "FROM RecipeIngredients WHERE ingredients_id = " + ingredient.getId() + " and recipe_id = " + recipe.getId();
            recipeIngredients = (RecipeIngredients)session.createQuery(query).uniqueResult();
            recipeIngredients.setQuantity(quantity);
            session.update(recipeIngredients);
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
    
    public static boolean changeMeasurementType(Integer ingredient_id, Integer recipe_id, Measurement measurement){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        RecipeIngredients recipeIngredients = null;
        boolean success = false;
        try{
            tx = session.beginTransaction();
            String query = "FROM RecipeIngredients WHERE ingredients_id = " + ingredient_id + " and recipe_id = " + recipe_id;
            recipeIngredients = (RecipeIngredients)session.createQuery(query).uniqueResult();
            recipeIngredients.setMeasurement(measurement);
            session.update(recipeIngredients);
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
    
    public static boolean changeMeasurementType(String ingredient_name, String recipe_name, Measurement measurement){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Recipe recipe = null;
        Ingredients ingredient = null;
        RecipeIngredients recipeIngredients = null;
        boolean success = false;
        try{
            tx = session.beginTransaction();
            String recipe_query = "FROM Recipe WHERE lower(name) = lower('" + recipe_name + "')";
            recipe = (Recipe)session.createQuery(recipe_query).uniqueResult();
            String ingredient_query = "FROM Ingredients WHERE lower(name) = lower('" + ingredient_name + "')";
            ingredient = (Ingredients)session.createQuery(ingredient_query).uniqueResult();
            String query = "FROM RecipeIngredients WHERE ingredients_id = " + ingredient.getId() + " and recipe_id = " + recipe.getId();
            recipeIngredients = (RecipeIngredients)session.createQuery(query).uniqueResult();
            recipeIngredients.setMeasurement(measurement);
            session.update(recipeIngredients);
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
    
    public static boolean deleteAssociation(Recipe recipe){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<RecipeIngredients> recipeIngredients;
        boolean success = false;
        try{
            tx = session.beginTransaction();
            String query = "FROM RecipeIngredients WHERE recipe_id = " + recipe.getId();
            recipeIngredients = session.createQuery(query).list();
            if (!recipeIngredients.isEmpty()){
                for (Iterator iter = recipeIngredients.iterator(); iter.hasNext();){
                    RecipeIngredients recipeIngredient = (RecipeIngredients) iter.next();
                    session.delete(recipeIngredient);
                }
            }
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
    
}
