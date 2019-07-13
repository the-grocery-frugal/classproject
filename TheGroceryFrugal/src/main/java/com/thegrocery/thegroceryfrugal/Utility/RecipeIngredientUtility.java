/**
 * File: RecipeIngredientUtility.java
 * Author: jacob
 * Date: 6/16/2019
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
 * Utility class to deal with RecipeIngredient.
 *
 * @author jacob
 */
public class RecipeIngredientUtility {
    
    /**
     * Associates a specified ingredient with a specified recipe.
     *
     * @param recipe      a recipe
     * @param ingredient  an ingredient
     * @param measurement a measurement
     * @return an ID of a new RecipeIngredient
     */
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
    
    /**
     * Associates a specified ingredient with a specified recipe.
     *
     * @param recipe      a recipe
     * @param ingredient  an ingredient
     * @param measurement a measurement
     * @param quantity    a quantity
     * @return an ID of a new RecipeIngredient
     */
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
    
    /**
     * Associates a specified ingredient with a specified recipe.
     *
     * @param recipe      a recipe
     * @param ingredient  an ingredient
     * @param measurement a measurement
     * @param quantity    a quantity
     * @param description a description
     * @return an ID of a new RecipeIngredient
     */
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
    
    /**
     * Changes a quantity of recipe ingredient found by ingredient id and recipe id.
     *
     * @param ingredient_id an ingredient id to search
     * @param recipe_id     a recipe id to search
     * @param quantity      a new quantity
     * @return true of recipe ingredient exists or false otherwise
     */
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
    
    /**
     * Changes a quantity of recipe ingredient found by ingredient name and recipe name.
     *
     * @param ingredient_name an ingredient name
     * @param recipe_name     a recipe name
     * @param quantity        a new quantity
     * @return true of recipe ingredient exists or false otherwise
     */
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
    
    /**
     * Changes a measurement type for and recipe ingredient found by ingredient if and recipe id.
     *
     * @param ingredient_id an ingredient id
     * @param recipe_id     a recipe id
     * @param measurement   a new measurement
     * @return true of recipe ingredient exists or false otherwise
     */
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
    
    /**
     * Changes a measurement type for and recipe ingredient found by ingredient name and recipe name.
     *
     * @param ingredient_name an ingredient name
     * @param recipe_name     a recipe name
     * @param measurement     a new measurement
     * @return true of recipe ingredient exists or false otherwise
     */
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
    
    /**
     * Deletes all associated ingredients for a given recipe
     *
     * @param recipe a recipe
     * @return true of recipe exists or false otherwise
     */
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
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
        	session.close();
        }
        
        return success;
    }
    
    /**
     * Deletes all associated ingredients for a given recipe
     *
     * @param recipe a recipe
     * @param ingredient a ingredient
     * @return true of recipe exists or false otherwise
     */
    public static boolean deleteAssociation(Recipe recipe, Ingredients ingredient){
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
                    if (recipeIngredient.getIngredients().getName().equals(ingredient.getName())){
                        session.delete(recipeIngredient);
                    }
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
    
    /**
     * Deletes all associated ingredients for a given recipe
     *
     * @param recipeIngredient an associated recipeIngredient
     * @return true of recipe exists or false otherwise
     */
    public static boolean deleteAssociation(RecipeIngredients recipeIngredient){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        boolean success = false;
        try{
            tx = session.beginTransaction();
            session.delete(recipeIngredient);
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
