package com.example.rest;

public class Product {

    private String sku;
    private String quantity;

    public Product(final String sku, final String quantity) {
        this.sku = sku;
        this.quantity = quantity;
    }

    public String getSku() {
        return this.sku;
    }

    public String getQuantity() {
        return this.quantity;
    }

}
