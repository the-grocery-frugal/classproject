/**
 * File: RecipeUtility.java
 * Author: jacob
 * Date: 6/16/2019
 */
package com.thegrocery.thegroceryfrugal.Utility;

import com.thegrocery.thegroceryfrugal.HibernateUtil;
import com.thegrocery.thegroceryfrugal.Models.Categories;
import com.thegrocery.thegroceryfrugal.Models.Recipe;
import com.thegrocery.thegroceryfrugal.Models.Users;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Utility class to deal with Recipes.
 *
 * @author jacob
 */
public class RecipeUtility {
    
    /**
     * Adds a recipe to the database.
     *
     * @param recipeName a recipe name
     * @param user       a recipe user
     * @return an ID of a new recipe
     */
    public static Integer addRecipe(String recipeName, Users user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Integer recipeID = null;
        try {
            tx = session.beginTransaction();
            Recipe recipe = new Recipe(recipeName, user);
            recipeID = (Integer) session.save(recipe);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return recipeID;    
    }
    
    /**
     * Adds a recipe to the database.
     *
     * @param recipeName  a recipe name
     * @param description a recipe description
     * @param user        a recipe user
     * @return an ID of a new recipe
     */
    public static Integer addRecipe(String recipeName, String description, Users user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Integer recipeID = null;
        try {
            tx = session.beginTransaction();
            Recipe recipe = new Recipe(recipeName,description,user);
            recipeID = (Integer) session.save(recipe);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return recipeID;    
    }
    
    /**
     * Adds a recipe to the database.
     *
     * @param recipeName  a recipe name
     * @param description a recipe description
     * @param steps       a recipe steps
     * @param user        a recipe user
     * @return an ID of a new recipe
     */
    public static Integer addRecipe(String recipeName, String description, String steps, Users user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Integer recipeID = null;
        try {
            tx = session.beginTransaction();
            Recipe recipe = new Recipe(recipeName, description, steps, user);
            recipeID = (Integer) session.save(recipe);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return recipeID;    
    }
    
    /**
     * Adds steps to a recipe by its name.
     *
     * @param user  an user
     * @param name  a recipe name to search
     * @param steps a new Step
     * @return true if recipe is found or false otherwise
     */
    public static boolean changeSteps(Users user, String name, String steps) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Recipe recipe = null;
        boolean success = false;
        try {
            tx = session.beginTransaction();
            String query = "FROM Recipe where name='" + name + "' AND user_id = " + user.getId();
            recipe = (Recipe) session.createQuery(query).uniqueResult();
            recipe.setSteps(steps);
            session.update(recipe);
            tx.commit();
            success = true;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return success;
    }
    
    /**
     * Adds steps to a recipe by its ID.
     *
     * @param user     an user
     * @param recipeID a recipe id to search
     * @param steps    a new Step
     * @return true if recipe is found or false otherwise
     */
    public static boolean changeSteps(Users user, Integer recipeID, String steps) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Recipe recipe = null;
        boolean success = false;
        try {
            tx = session.beginTransaction();
            recipe = (Recipe)session.get(Recipe.class, recipeID);
            if (recipe.getUser() == user){
                recipe.setSteps(steps);
                session.update(recipe);
                tx.commit();
                success = true;
            }
            
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return success;
    }
    
    /**
     * Adds a description to a recipe by its name.
     *
     * @param user        an recipe user
     * @param name        an recipe name to search
     * @param description a description to add
     * @return true if recipe is found or false otherwise
     */
    public static boolean changeDescription(Users user, String name, String description) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Recipe recipe = null;
        boolean success = false;
        try {
            tx = session.beginTransaction();
            String query = "FROM Recipe where name='" + name + "' AND user_id =" + user.getId();
            recipe = (Recipe) session.createQuery(query).uniqueResult();
            recipe.setDescription(description);
            session.update(recipe);
            success = true;
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return success;
    }
    
    /**
     * Adds a description to a recipe by its ID.
     *
     * @param user        an recipe user
     * @param recipeID    an recipe id to search
     * @param description a description to add
     * @return true if recipe is found or false otherwise
     */
    public static boolean changeDescription(Users user, Integer RecipeID, String description) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Recipe recipe = null;
        boolean success = false;
        try {
            tx = session.beginTransaction();
            recipe = (Recipe)session.get(Recipe.class, RecipeID);
            if (recipe.getUser() == user){
                recipe.setDescription(description);
                session.update(recipe);
                success = true;
                tx.commit();
            }
            
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        } 
        
        return success;
    }
    
    /**
     * Sets category of a recipe found by name.
     *
     * @param name     a recipe name to search
     * @param category a new category
     * @return true if recipe is found or false otherwise
     */
    public static boolean addCategory(String name, Categories category){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Recipe recipe = null;
        boolean success = false;
        try{
            tx = session.beginTransaction();
            String query = "FROM Recipe WHERE lower(name) = '" + name + "'";
            recipe = (Recipe)session.createQuery(query).uniqueResult();
            recipe.setCategories(category);
            session.update(recipe);
            success = true;
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return success;
    }
    
    /**
     * Changes recipe name.
     *
     * @param old_name old name
     * @param new_name new name
     * @return true if recipe is found or false otherwise
     */
    public static boolean changeName(String old_name, String new_name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Recipe recipe = null;
        boolean success = false;
        try {
            tx = session.beginTransaction();
            String query = "FROM Recipe where name='" + old_name + "'";
            recipe = (Recipe) session.createQuery(query).uniqueResult();
            recipe.setName(new_name);
            session.update(recipe);
            success = true;
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return success;
    }
    
    /**
     * Retrieves and returns a list of all recipes matching a specified name.
     *
     * @param name a name to search.
     * @return a list of all found recipes
     */
    public static List<Recipe> findRecipeByName(String name){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<Recipe> recipes = null;
        try {
            tx = session.beginTransaction();
            String query = "FROM Recipe WHERE lower(name) like lower('%" + name + "%')";
            recipes = session.createQuery(query).list();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return recipes;
    }
    
    /**
     * Retrieves and returns a list of all recipes in a given category.
     *
     * @return a list of all recipes
     */
    public static List<Recipe> findRecipeByCategory(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<Recipe> recipes = null;
        try {
            tx = session.beginTransaction();
            
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return recipes;
    }
    
    /**
     * Finds a list of all recipe matching an ingredients name.
     *
     * @param ingredient an ingredients name
     * @return a list of all recipe found
     */
    public static List<Recipe> findRecipeByIngredientName(String ingredient, Users user){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<Recipe> recipes = null;
        try {
            tx = session.beginTransaction();
            String query = "SELECT R FROM Recipe R " + 
                            "LEFT JOIN R.recipeIngredientses RI " +
                            "LEFT JOIN RI.ingredients I " +
                            "WHERE lower(I.name) like lower('%" + ingredient + "%') " +
                            "AND user_id = " + user.getId() + 
                            "OR user_id = 19";
                            
            recipes = session.createQuery(query).list();
            
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return recipes;
    }
    
    /**
     * Returns a Recipe object found by name.
     *
     * @param recipe_name a recipe name to search
     * @return a Recipe object found or null otherwise
     */
    public static Recipe getRecipe(String recipe_name){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        Recipe recipe = null;
        try {
            tx = session.beginTransaction();
            String query = "FROM Recipe R WHERE R.name = '" + recipe_name + "'";
            recipe = (Recipe)session.createQuery(query).uniqueResult();
        } catch (HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return recipe;
    }
    
    /**
     * Simply list all recipes.
     *
     * @return a list of all recipes.
     */
    public static List<Recipe> listAllRecipes(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<Recipe> recipes = null;
        try {
            session.beginTransaction();
            String query = "FROM Recipe";
            recipes = session.createQuery(query).list();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return recipes;
    }
    
    /**
     * Deleted a recipe from database.
     *
     * @param recipe a recipe
     * @param user   an user
     * @return true if recipe is found or false otherwise
     */
    public static boolean deleteRecipe(Recipe recipe, Users user){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        boolean success = false;
        if (recipe.getUser() == null || !recipe.getUser().equals(user)) {
            return success;
        }
        try {
            tx = session.beginTransaction();
            if (RecipeIngredientUtility.deleteAssociation(recipe, false)
            		&& GroceryListUtility.deleteAssociation(recipe, false)){
                session.delete(recipe);
            }
            tx.commit();
            
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return success;
    }
    
    /**
     * Author: Amanda Kok Gathers all default recipes, that are associated with
     * all users, and returns them.
     *
     * @return Returns a list of all default recipes
     */
    public static List<Recipe> gatherRecipes(long id) {
        List<Recipe> gatheredRecipes = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        
        try {
            session.beginTransaction();
            String query = "FROM Recipe WHERE user_id = " + id;
            gatheredRecipes = session.createQuery(query).list();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return gatheredRecipes;
    }

	public static List<Recipe> listAllUserAndDefaultRecipes(Users user) {
		List<Recipe> userRecipes = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            String query = "FROM Recipe WHERE user_id = 19 OR user_id = " + user.getId();
            userRecipes = session.createQuery(query).list();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
		return userRecipes;
	}
    
}
