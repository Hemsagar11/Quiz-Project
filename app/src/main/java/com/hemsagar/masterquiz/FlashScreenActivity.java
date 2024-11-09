package com.hemsagar.masterquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class FlashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(FlashScreenActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 2000); // 2 seconds delay
    }
}