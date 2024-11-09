package com.hemsagar.masterquiz;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;

public class FlashScreenActivity extends AppCompatActivity {
    private static final int SPLASH_DISPLAY_LENGTH = 2000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);

        ImageView logo = findViewById(R.id.amritaLogo);
        logo.setImageResource(R.drawable.amrita_logo); // Place amrita_logo.png in res/drawable

        new Handler().postDelayed(() -> {
            Intent mainIntent = new Intent(FlashScreenActivity.this, HomeActivity.class);
            startActivity(mainIntent);
            finish();
        }, SPLASH_DISPLAY_LENGTH);
    }
}
