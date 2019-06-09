/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thegrocery.thegroceryfrugal.Utility;

import com.thegrocery.thegroceryfrugal.HibernateUtil;
import com.thegrocery.thegroceryfrugal.Models.Users;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author jacob
 */
public class UserUtility {
    
    private String generatePassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }
    
    // Create a user account, must have a username and password
    public boolean createUser(String username, String password){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Users user = new Users(username, generatePassword(password));
            session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
            return true;
        }
        
    }
    
    
    // Check if the provided username and password is correct
    // TODO: Add username checking capability.  If the username doesn't exist at all,
    // no point in checking if the passwords    
    public boolean checkPassword(String username, String password){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        boolean authenticated = false;
        try {
            tx = session.beginTransaction();
            String query = "FROM Users U WHERE U.username = '" + username + "'";
            Users user = (Users)session.createQuery(query).uniqueResult();
            
            if (user != null) {
                // compare password hashse
                if (BCrypt.checkpw(password, user.getPassword())){
                    authenticated = true;
                } else {
                    authenticated = false;
                }
            } else {
                authenticated = false;
            }
            
        } catch (HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return authenticated;
    }
    
}
