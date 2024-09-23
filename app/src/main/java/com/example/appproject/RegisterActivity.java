package com.example.appproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    Button btRegister;
    EditText Name;
    EditText Password;
    EditText Email;
    EditText Phone;
    Button haveAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btRegister = findViewById(R.id.btRegister);
        Name = findViewById(R.id.name);
        Password = findViewById(R.id.password);
        Email = findViewById(R.id.email);
        Phone = findViewById(R.id.phoneNumber);
        haveAccount = findViewById(R.id.btHaveAccount);


        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDetails user = new UserDetails("", "", "", "");
                user.setUserName(Name.getText().toString());
                user.setUserPwd(Password.getText().toString());
                user.setUserEmail(Email.getText().toString());
                user.setUserPhone(Phone.getText().toString());

                Intent intent = new Intent(RegisterActivity.this, HomePage.class);
                intent.putExtra("name",user.getUserName());
                startActivity(intent);
            }
        });

        haveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.returnToOpening) {
            Intent intent = new Intent( RegisterActivity.this , OpeningScreen.class);
            startActivity(intent);
            return true;
        }
        if (id ==R.id.closeApp){
            finishAffinity();
        }
        return super.onOptionsItemSelected(item);
    }
}