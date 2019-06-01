/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thegrocery.thegroceryfrugal;

/**
 *
 */
public class Ingredient {
    
    private Product product;
    
    private int quantity;

    public Ingredient(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Ingredient() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Ingredient{" + "product=" + product + ", quantity=" + quantity + "}<br>";
    }
    
}
