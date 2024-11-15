package com.hemsagar.masterquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class FlashScreenActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "MasterQuizPrefs";
    private static final String FIRST_LAUNCH_KEY = "first_launch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Check if it's the first launch
                if (isFirstLaunch()) {
                    // Initialize Firestore setup helper class
                    FirestoreSetupHelper firestoreSetupHelper = new FirestoreSetupHelper();
                    firestoreSetupHelper.setupFirestoreData();

                    setFirstLaunchFlag(false);
                }

                // Proceed to MainActivity after the setup is done
                Intent intent = new Intent(FlashScreenActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000); // Splash screen delay (2 seconds)
    }

    private boolean isFirstLaunch() {
        return sharedPreferences.getBoolean(FIRST_LAUNCH_KEY, true);
    }

    private void setFirstLaunchFlag(boolean isFirstLaunch) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(FIRST_LAUNCH_KEY, isFirstLaunch);
        editor.apply();
    }
}
