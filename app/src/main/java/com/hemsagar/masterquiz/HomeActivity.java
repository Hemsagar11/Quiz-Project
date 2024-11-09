package com.hemsagar.masterquiz;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        CardView natureCard = findViewById(R.id.cardNature);
        CardView scienceCard = findViewById(R.id.cardScience);
        CardView csCard = findViewById(R.id.cardCS);

        natureCard.setOnClickListener(v -> startQuiz("Nature"));
        scienceCard.setOnClickListener(v -> startQuiz("Science"));
        csCard.setOnClickListener(v -> startQuiz("Computer Science"));
    }

    private void startQuiz(String topic) {
        Intent quizIntent = new Intent(HomeActivity.this, QuizActivity.class);
        quizIntent.putExtra("TOPIC", topic);
        startActivity(quizIntent);
    }

}