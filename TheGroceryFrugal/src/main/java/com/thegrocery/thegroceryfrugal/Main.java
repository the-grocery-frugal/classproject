/**
 * File: Main.java
 * Author: jacob
 * Date: 6/16/2019
 */
package com.thegrocery.thegroceryfrugal;

import com.thegrocery.thegroceryfrugal.GUI.Login;
import org.hibernate.Session;

/**
 * The entry point into the program.
 *
 * @author jacob
 */
public class Main {
    /**
     * Login frame.
     */
    public static Login login;

    /**
     * Runs application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            login = new Login();
            login.setVisible(true);
            login.setLocationRelativeTo(null);
        } finally {
            session.close();
        }
    }
}
