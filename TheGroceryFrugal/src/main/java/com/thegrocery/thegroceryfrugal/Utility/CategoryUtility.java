/**
 * File: CategoryUtility.java
 * Author: jacob
 * Date: 6/16/2019
 */

package com.thegrocery.thegroceryfrugal.Utility;

import com.thegrocery.thegroceryfrugal.HibernateUtil;
import com.thegrocery.thegroceryfrugal.Models.Categories;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Utility class to deal with "categories" table.
 *
 * @author jacob
 */
public class CategoryUtility {
    /**
     * Retrieves from database and returns a list of all categories.
     *
     * @return a list of all categories
     */
    public static List<Categories> getAllCategories(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<Categories> categories = null;
        
        try {
            tx = session.beginTransaction();
            String query = "SELECT Cat FROM Categories Cat";
            categories = session.createQuery(query).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return categories;
    }
}
