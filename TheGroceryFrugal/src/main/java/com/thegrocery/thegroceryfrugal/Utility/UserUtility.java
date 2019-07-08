/**
 * File: UserUtility.java
 * Author: jacob
 * Date: 6/16/2019
 */
package com.thegrocery.thegroceryfrugal.Utility;

import com.thegrocery.thegroceryfrugal.HibernateUtil;
import com.thegrocery.thegroceryfrugal.Models.Users;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Utility class to deal with Users.
 *
 * @author jacob
 */
public class UserUtility {
    
    /**
     * Generates a new password based on given string.
     *
     * @param password password string
     * @return a generated password
     */
    private static String generatePassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }
    
    /**
     * Creates a new account and puts it to database.
     *
     * @param username an username
     * @param password a password
     * @return true if new user was created successfully or false otherwise
     */
    public static boolean createUser(String username, String password){
        // check to see is given username already registered
        if (getUser(username) != null) {
            return false;
        }
        
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
            
        }
        
        return true;
        
    }
    
    
    /**
     * Checks if the provided username and password is correct
     *
     * @param username a username
     * @param password a password
     * @return true if this user present and password match or false otherwise
     */   
    public static boolean checkPassword(String username, String password){
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
    
    /**
     * Get User object by username
     *
     * @param username an username
     * @return an User object found or null otherwise
     */
    public static Users getUser(String username){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Users user = null;
        try {
            tx = session.beginTransaction();
            String query = "FROM Users U WHERE U.username = '" + username + "'";
            user = (Users)session.createQuery(query).uniqueResult();
        } catch (HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return user;
    }
    
}
