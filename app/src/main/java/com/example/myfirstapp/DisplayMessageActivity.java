package com.example.myfirstapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.rest.Product;

import org.json.JSONObject;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        new HttpRequestTask().execute();
    }

    private class HttpRequestTask extends AsyncTask<Void, Void, JSONObject> {
        @Override
        protected JSONObject doInBackground(Void... params) {
            try {
                final String url = "http://sample-env.mq9gh7xwxe.us-east-2.elasticbeanstalk.com/products";
                RestTemplate restTemplate = new RestTemplate();
                String productData = restTemplate.getForObject(url, String.class);
                JSONObject object = new JSONObject(productData);
                Log.d("JSON", object.toString());
                return new JSONObject(productData);
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }


    }
}
