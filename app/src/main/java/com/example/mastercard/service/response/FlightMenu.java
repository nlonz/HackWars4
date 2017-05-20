package com.example.mastercard.service.response;

import java.io.Serializable;
import java.util.List;

public class FlightMenu implements Serializable {

    private static final long serialVersionUID = 7930276594547440991L;
    private final List<MenuProduct> drinks;
    private final List<MenuProduct> foods;

    public FlightMenu(List<MenuProduct> drinks, List<MenuProduct> foods, String outletId, String locatedScanId) {
        this.drinks = drinks;
        this.foods = foods;
    }

    public List<MenuProduct> getDrinks() {
        return drinks;
    }

    public List<MenuProduct> getFoods() {
        return foods;
    }
}
