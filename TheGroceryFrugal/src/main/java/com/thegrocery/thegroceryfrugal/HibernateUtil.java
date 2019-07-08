/**
 * File: HibernateUtil.java
 * Author: jacob
 * Date: 6/16/2019
 */
package com.thegrocery.thegroceryfrugal;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author jacob
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    /**
     * Returns the SessionFactory object.
     *
     * @return the SessionFactory object     * @return the SessionFactory object
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
