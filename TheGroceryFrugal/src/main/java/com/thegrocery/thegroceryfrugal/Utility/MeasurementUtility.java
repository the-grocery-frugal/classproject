/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thegrocery.thegroceryfrugal.Utility;

import com.thegrocery.thegroceryfrugal.HibernateUtil;
import com.thegrocery.thegroceryfrugal.Models.Measurement;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jacob
 */
public class MeasurementUtility {
    public static Integer addMeasurement(String name){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Measurement measurement = null;
        Integer measurementID = null;
        
        try {
            tx = session.beginTransaction();
            measurement = new Measurement(name);
            measurementID = (Integer)session.save(measurement);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return measurementID;
    }
    
    public static Measurement findMeasurement(String name){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Measurement measurement = null;
        
        try{
            tx = session.beginTransaction();
            String query = "FROM Measurement WHERE lower(name) = lower('" + name + "')";
            measurement = (Measurement)session.createQuery(query).uniqueResult();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return measurement;
    }
    
    public static List<Measurement> listAllMeasurements(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<Measurement> measurements = null;
        
        try{
            tx = session.beginTransaction();
            String query = "FROM Measurement";
            measurements = session.createQuery(query).list();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return measurements;
    }
    
    public static void blankMethod(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        
        try{
            
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
