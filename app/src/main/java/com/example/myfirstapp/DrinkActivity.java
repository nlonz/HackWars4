package com.example.myfirstapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.mastercard.service.providers.MasterCardLogInService;
import com.example.mastercard.service.providers.MasterCardShoppingCartService;
import com.example.mastercard.service.request.LogInRequest;
import com.example.mastercard.service.response.FlightMenu;
import com.example.mastercard.service.response.ShoppingSession;

import org.json.JSONObject;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private FlightMenu menu;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        menu  = (FlightMenu) getIntent().getSerializableExtra("EXTRA_MENU");
    }

    public void selectRedWine(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = "You Have Selected Red Wine";
        intent.putExtra(EXTRA_MESSAGE, message);
        ShoppingSession shopSession = new HttpRequestTask().doInBackground();
        String token = shopSession.getAccessToken();
        intent.putExtra("EXTRA_SESSION", token);
        MasterCardShoppingCartService shoppingCart = new MasterCardShoppingCartService();
        String cartId = shoppingCart.addToCart(shopSession, menu, menu.getDrinks().get(0));
        intent.putExtra("EXTRA_CART_ID", cartId);
        startActivity(intent);
    }

    public void selectBud(View view) {
        intent = new Intent(this, DisplayMessageActivity.class);
        new HttpRequestTask().execute();
    }

    private class HttpRequestTask extends AsyncTask<Void, Void, ShoppingSession> {

        @Override
        protected ShoppingSession doInBackground(Void... params) {
            try {
                final String url = "http://sample-env.mq9gh7xwxe.us-east-2.elasticbeanstalk.com/products";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                String productData = restTemplate.getForObject(url, String.class);
                JSONObject object = new JSONObject(productData);
                Log.d("JSON", object.toString());
            } catch (Exception e) {
                Log.e("DrinkActivity", e.getMessage(), e);
            }
            LogInRequest logInRequest = new LogInRequest("jeb.watkins@aa.com", "starMuppets1");
            MasterCardLogInService service = new MasterCardLogInService();
            return service.logInUser(logInRequest);
        }

        @Override
        protected void onPostExecute(ShoppingSession session) {
            String message = "You Have Selected Bud Light";
            intent.putExtra(EXTRA_MESSAGE, message);
            String token = session.getAccessToken();
            intent.putExtra("EXTRA_SESSION", token);
            MasterCardShoppingCartService shoppingCart = new MasterCardShoppingCartService();
            String cartId = shoppingCart.addToCart(session, menu, menu.getDrinks().get(1));
            intent.putExtra("EXTRA_CART_ID", cartId);
            startActivity(intent);
        }
    }
}
