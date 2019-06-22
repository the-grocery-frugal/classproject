/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thegrocery.thegroceryfrugal.Utility;

import com.thegrocery.thegroceryfrugal.HibernateUtil;
import com.thegrocery.thegroceryfrugal.Models.GroceryList;
import com.thegrocery.thegroceryfrugal.Models.Recipe;
import com.thegrocery.thegroceryfrugal.Models.Users;
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
}
