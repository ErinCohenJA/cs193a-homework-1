package com.erincohen.hw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private boolean todayPredicted;
    private boolean secretPredicted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        todayPredicted = false;
        secretPredicted = false;
    }

    public void buttonClick(View view) {
        // runs when the button gets clicked
        if (todayPredicted == false) {
            Toast.makeText(this, "predicting your day", Toast.LENGTH_LONG).show();
            predict();
            todayPredicted = true;
        } else {
            Toast.makeText(this, "already predicted your day, honey", Toast.LENGTH_SHORT).show();
        }
    }

    public void predict(){
        // generates one of three possible predictions for crystal ball
        TextView forecast = (TextView) findViewById(R.id.result);
        Random randy = new Random();
        int prediction = randy.nextInt(2);
        if (prediction == 2){
            forecast.setText("Forecast: Slay day. YASSSSS!");
        } else if (prediction == 1) {
            forecast.setText("Forecast: Meh. It's whadever yo.");
        } else if (prediction == 0){
            forecast.setText("Forecast: The sun will come out tomorrow tbh. Have a drink on me.");
        }

    }

    public void secretClick(View view) {
        //generates bonus random message via toast
        if (secretPredicted == false) {
            Random randy = new Random();
            int secret = randy.nextInt(1);
            if (secret == 0) {
                Toast.makeText(this, "Someone is cheating on you.", Toast.LENGTH_SHORT).show();
            } else if (secret == 1) {
                Toast.makeText(this, "Someoene has a crush on you.", Toast.LENGTH_SHORT).show();
            }
            secretPredicted = true;
        } else {
            Toast.makeText(this, "Already told you a secret, geesh. You're welcome.", Toast.LENGTH_SHORT).show();
        }

    }
}
