/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thegrocery.thegroceryfrugal;

import com.thegrocery.thegroceryfrugal.Models.Ingredients;
import com.thegrocery.thegroceryfrugal.Models.Measurement;
import com.thegrocery.thegroceryfrugal.Models.Recipe;
import com.thegrocery.thegroceryfrugal.Models.RecipeIngredients;
import com.thegrocery.thegroceryfrugal.Utility.IngredientUtility;
import com.thegrocery.thegroceryfrugal.Utility.MeasurementUtility;
import com.thegrocery.thegroceryfrugal.Utility.RecipeIngredientUtility;
import com.thegrocery.thegroceryfrugal.Utility.RecipeUtility;
import com.thegrocery.thegroceryfrugal.Utility.UserUtility;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jacob
 */
public class test {
    
    public static void main (String[] args) {
        UserUtility userutility = new UserUtility();
        IngredientUtility ingredientutility = new IngredientUtility();
        RecipeUtility recipeutility = new RecipeUtility();
        /*
        UserUtility.createUser("system-user", "really-hard-password");
        
        System.out.println(UserUtility.checkPassword("system-user", "really-hard-password"));
        */
        
        //recipeutility.findRecipeByIngredientName("test");
        
        
        /*
        
        CREATING A USER
        if (userutility.createUser("jacob", "password")) {
            System.out.println("user created");
        }
        
        CHECKING IF A USER'S PASSWORD IS CORRECT
        if (userutility.checkPassword("blah", "password")) {
            System.out.println("correct password");
        } else {
            System.out.println("incorrect password");
        }*/
        
        
        /*
        GET ALL RECIPES THAT HAVE THE INGREDIENT OF BANANA
        List recipes = recipeutility.findRecipeByIngredientName("banana");
        
        for (Iterator iter = recipes.iterator(); iter.hasNext();) {
            Recipe recipe = (Recipe)iter.next();
            System.out.println(recipe.getName());
            String steps = recipe.getSteps();
            steps = steps.replaceAll("\\r\\n|\\r|\\n", " ");
            System.out.println(steps);
        }*/
        
        /*
        try {
            
            Transaction tx = session.beginTransaction();
            ingredients = session.createSQLQuery("select * from ingredients").addEntity(Ingredients.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(ingredients);
        */
        
        /*
        
        // GET ALL INGREDIENTS FOR A RECIPE
        List ingredients = ingredientutility.listAllIngredientsForRecipe("Banana Berry Smoothie");
        for (Iterator iter = ingredients.iterator(); iter.hasNext(); ) {
            Ingredients ingredient = (Ingredients)iter.next();
            System.out.println(ingredient.getName());
        }
        */
        
        /*
        // CREATE A NEW RECIPE
        Integer testID = recipeutility.addRecipe("test_recipe");
        System.out.println(testID);
        */
        
        /*
        List<Recipe> recipes2 = recipeutility.findRecipeByIngredientName("berry");
        for (Iterator iter = recipes2.iterator(); iter.hasNext();) {
            Recipe recipe = (Recipe)iter.next();
            System.out.println(recipe.getId() + " " + recipe.getName());
        }

        
        List<Ingredients> ingredients = ingredientutility.findIngredientsByRecipeName("Banana Berry Smoothie");
        for (Iterator iter = ingredients.iterator(); iter.hasNext(); ) {
                Ingredients ingredient = (Ingredients) iter.next();
                System.out.println("ID: " + ingredient.getId());
                System.out.println("NAME: " + ingredient.getName());
        }
        
        
        // Creating an assocation between some test data
        Integer measurementID = MeasurementUtility.addMeasurement("test");
        Measurement testMeasurement = MeasurementUtility.findMeasurement("test").get(0);
        Integer recipeID = RecipeUtility.addRecipe("test");
        Recipe testRecipe = RecipeUtility.findRecipeByName("test").get(0);
        Integer ingredientsID = IngredientUtility.addIngredient("test");
        Ingredients testIngredient = IngredientUtility.findIngredientsByName("test").get(0);
        Integer recipeIngredientsID = RecipeIngredientUtility.associateIngredientToRecipe(testRecipe, testIngredient, testMeasurement, 100.0f);
        //Integer recipeIngredientsID = RecipeIngredientUtility.associateIngredientToRecipe(testRecipe, testIngredient, testMeasurement, 100.0f);
        System.out.println(recipeIngredientsID);
        */
        
    }
    
}
