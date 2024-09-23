package com.example.appproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText Name;
    EditText Password;
    CheckBox checkPass;
    Button Login;
    Button noAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Login = findViewById(R.id.btLogin);
        Name = findViewById(R.id.Lname);
        Password = findViewById(R.id.Lpassword);
        checkPass = findViewById(R.id.checkBoxPassword);
        noAccount = findViewById(R.id.btNoAccount);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDetails user = new UserDetails("", "");
                user.setUserName(Name.getText().toString());
                user.setUserPwd(Password.getText().toString());
                Intent intent1 = new Intent(LoginActivity.this, HomePage.class);
                intent1.putExtra("name", user.getUserName());
                startActivity(intent1);
            }
        });

        noAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        checkPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Password.setTransformationMethod(null);
                }
                else{
                    Password.setTransformationMethod(new PasswordTransformationMethod());
                }
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
            Intent intent = new Intent( LoginActivity.this , OpeningScreen.class);
            startActivity(intent);
            return true;
        }
        if (id ==R.id.closeApp){
            finishAffinity();
        }
        return super.onOptionsItemSelected(item);
    }
}