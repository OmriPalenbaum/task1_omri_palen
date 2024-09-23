package com.example.appproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView CDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CDT = findViewById(R.id.tvCDT);

        CountDownTimer cdt = new CountDownTimer(5000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                String stCountDown ="" + millisUntilFinished/1000;
                CDT.setText("Starts in " + stCountDown + " seconds");
            }

            @Override
            public void onFinish() {
                CDT.setText("Done!");
                Intent intent = new Intent(MainActivity.this, OpeningScreen.class);
                startActivity(intent);
            }
        }.start();
    }
}