package com.example.appproject;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    TextView tvWelcome;
    ImageView ivCamera;
//    Button btCamera;
    ActivityResultLauncher<Intent>arSmall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ivCamera = findViewById(R.id.ivCamera);
//        btCamera = findViewById(R.id.btCamera);
        tvWelcome = findViewById(R.id.tvWelcome);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        tvWelcome.setText("Welcome, " + name + ":)");

        ActivityCompat.requestPermissions(this,
                new String[]{android.Manifest.permission.CAMERA,
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        },
                1);

        arSmall = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent data = result.getData();
                        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                        ivCamera.setImageBitmap(bitmap);
                        ivCamera.setImageBitmap(result.getData().getParcelableExtra("data"));
//                        ivCamera.setVisibility(View.VISIBLE);
                    }
                });

        ivCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                arSmall.launch(intent);

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
                Intent intent = new Intent( HomePage.this , OpeningScreen.class);
            startActivity(intent);
            return true;
        }
        if (id ==R.id.closeApp){
            finishAffinity();
        }
        return super.onOptionsItemSelected(item);
    }
}