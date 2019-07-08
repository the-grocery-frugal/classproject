/**
 * File: MeasurementUtility.java
 * Author: jacob
 * Date: 6/16/2019
 */
package com.thegrocery.thegroceryfrugal.Utility;

import com.thegrocery.thegroceryfrugal.HibernateUtil;
import com.thegrocery.thegroceryfrugal.Models.Measurement;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Utility class to deal with "measurement" table.
 *
 * @author jacob
 */
public class MeasurementUtility {
    
    /**
     * Adds a new measurement to the database.
     *
     * @param name a new measurement name
     * @return an ID of a new measurement added
     */
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
    
    /**
     * Finds a measurement by its name
     *
     * @param name a measurement name
     * @return Measurement object if exists or null otherwise
     */
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
    
    /**
     * Returns list of all measurement.
     *
     * @return list of all measurement
     */
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
    
    /**
     * Do nothing - Used for adding more methods
     */
    private static void blankMethod(){
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
