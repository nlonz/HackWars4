package com.example.myfirstapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.mastercard.service.MasterCardCreditCardService;
import com.example.mastercard.service.MasterCardLogInService;
import com.example.mastercard.service.request.LogInRequest;
import com.example.mastercard.service.response.ShoppingSession;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
    }

    public void selectJack(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = "You Have Selected Jack Daniels";
        intent.putExtra(EXTRA_MESSAGE, message);




        ShoppingSession shopSession = new HttpRequestTask().doInBackground();
//        MasterCardCreditCardService ccService = new MasterCardCreditCardService();
//        ccService.getCreditCards(shopSession);
        String token = shopSession.getAccessToken();
        intent.putExtra(EXTRA_MESSAGE, token);
        startActivity(intent);
    }

    public void selectBud(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = "You Have Selected Bud Light";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    private class HttpRequestTask extends AsyncTask<Void, Void, ShoppingSession> {
        @Override
        protected ShoppingSession doInBackground(Void... params) {
            LogInRequest logInRequest = new LogInRequest("jeb.watkins@aa.com", "starMuppets1");
            MasterCardLogInService service = new MasterCardLogInService();
            return service.logInUser(logInRequest);
        }
    }
}
