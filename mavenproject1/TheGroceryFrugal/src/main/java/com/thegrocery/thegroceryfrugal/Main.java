/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thegrocery.thegroceryfrugal;

import com.thegrocery.thegroceryfrugal.GUI.Login;
import org.hibernate.Session;

/**
 *
 * @author jacob
 */
public class Main {
    public static void main(String[] args){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Login login = new Login();
        login.setVisible(true);
        session.close();
    }
}
