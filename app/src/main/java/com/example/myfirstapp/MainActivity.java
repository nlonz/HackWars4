package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mastercard.service.providers.MasterCardProductsService;
import com.example.mastercard.service.response.FlightMenu;
import com.example.mastercard.service.response.MenuProduct;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectDrinks(View view) {
        Intent intent = new Intent(this, DrinkActivity.class);
        MasterCardProductsService productsService = new MasterCardProductsService();
        FlightMenu menu = productsService.getMenu();
        intent.putExtra("EXTRA_MENU", menu);
        startActivity(intent);
    }
}
