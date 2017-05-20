package com.example.mastercard.service.response;

import java.io.Serializable;

public class MenuProduct implements Serializable {

    private static final long serialVersionUID = 182787365613580705L;
    private final String name;
    private final String price;
    private final String variantId;

    public MenuProduct(String name, String price, String variantId) {
        this.name = name;
        this.price = price;
        this.variantId = variantId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getVariantId() {
        return variantId;
    }
}
