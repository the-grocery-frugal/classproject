/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thegrocery.thegroceryfrugal.Utility;

import com.thegrocery.thegroceryfrugal.HibernateUtil;
import com.thegrocery.thegroceryfrugal.Models.GroceryList;
import com.thegrocery.thegroceryfrugal.Models.Ingredients;
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
public class GroceryListUtility {
    // Add a grocery_list to the database
    public static Integer addGroceryList(Users user, Recipe recipe) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Integer groceryListID = null;
        try {
            tx = session.beginTransaction();
            GroceryList groceryList = new GroceryList(user, recipe);
            groceryListID = (Integer) session.save(groceryList);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return groceryListID;    
    }
    
    public static Integer addGroceryList(Users user, Recipe recipe, String title) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Integer groceryListID = null;
        try {
            tx = session.beginTransaction();
            GroceryList groceryList = new GroceryList(user, recipe, title);
            groceryListID = (Integer) session.save(groceryList);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return groceryListID;    
    }
    
    public static boolean changeName(GroceryList groceryList, String new_name){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        boolean success = false;
        
        try {
            tx = session.beginTransaction();
            groceryList.setTitle(new_name);
            success = true;
            tx.commit();
        } catch (HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally{
            session.close();
        }
        
        return success;
    }
    
    public static boolean changeName(Users user, String old_name, String new_name){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        GroceryList groceryList = null;
        boolean success = false;
        
        try {
            tx = session.beginTransaction();
            String query = "FROM GroceryList where lower(name) = lower('" + old_name + "') AND user_id =" + user.getId();
            groceryList = (GroceryList)session.createQuery(query).uniqueResult();
            groceryList.setTitle(new_name);
            success = true;
            tx.commit();
        } catch (HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally{
            session.close();
        }
        
        return success;
    }
    
    /**
     * Author: Amanda Kok
     * Gathers all grocery lists stored with user id and returns them
     * @param id user id to search by
     * @return returns a list of all lists added with user id, id
     */
    public static List<GroceryList> gatherUserGroceryLists(long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<GroceryList> lists = null;
        
        try {
            tx = session.beginTransaction();
            String query = "FROM GroceryList WHERE user_id = " + id;
            lists = session.createQuery(query).list();
        }catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            } 
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return lists;
    }
    
    /**
     * Author: Amanda Kok
     * Gathers all ingredients related to recipe id parameter
     * @param listID recipe id
     * @return Returns a list of all ingredients associated with a recipe id
     */
    public static List<Ingredients> gatherListIngredients(long listID) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        GroceryList list = null;
        Recipe recipe = null;
        
        try {
            tx = session.beginTransaction();
            
            String query = "FROM GroceryList WHERE id = " + listID;
            list = (GroceryList)session.createQuery(query).uniqueResult();
            
            recipe = list.getRecipe_id();
            //String query2 = "FROM Recipe WHERE id = " + list.getRecipe_id();
            //recipe = (Recipe)session.createQuery(query2).uniqueResult();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        List<Ingredients> ingredients = IngredientUtility.findIngredientsByRecipeName(recipe.getName());
        
        return ingredients;
    }
}
