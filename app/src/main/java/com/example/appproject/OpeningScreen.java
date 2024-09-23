package com.example.appproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OpeningScreen extends AppCompatActivity {

    Button logIn;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_screen);

        logIn = findViewById(R.id.login);
        signUp = findViewById(R.id.signup);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(OpeningScreen.this, LoginActivity.class);
                startActivity(intent1);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpeningScreen.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}