package com.hemsagar.masterquiz;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class ScoreSummaryActivity extends AppCompatActivity {

    private TextView scorePercentageText, correctAnswersText;
    private Button playAgainButton, viewHistoryButton;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_summary);

        // Initialize Firestore
        db = FirebaseFirestore.getInstance();

        // UI elements
        scorePercentageText = findViewById(R.id.scorePercentage);
        correctAnswersText = findViewById(R.id.correctAnswers);
        playAgainButton = findViewById(R.id.playAgainButton);
        viewHistoryButton = findViewById(R.id.viewHistoryButton);

        // Retrieve score and total questions from intent
        int score = getIntent().getIntExtra("SCORE", 0);
        int totalQuestions = getIntent().getIntExtra("TOTAL_QUESTIONS", 0);
        String topic = getIntent().getStringExtra("TOPIC");

        // Calculate score percentage
        int scorePercentage = (int) ((score / (double) totalQuestions) * 100);

        // Display score and correct answers
        scorePercentageText.setText("Score: " + scorePercentage + "%");
        correctAnswersText.setText("Correct Answers: " + score);

        // Save score to Firestore
        saveScoreToFirestore(score, totalQuestions);

        // Set up button listeners
        playAgainButton.setOnClickListener(v -> {
            Intent intent = new Intent(ScoreSummaryActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });

        viewHistoryButton.setOnClickListener(v -> {
            Intent intent = new Intent(ScoreSummaryActivity.this, HistoryActivity.class);
            startActivity(intent);
        });
    }

    private void saveScoreToFirestore(int score, int totalQuestions) {
        Map<String, Object> scoreData = new HashMap<>();
        scoreData.put("score", score);
        scoreData.put("totalQuestions", totalQuestions);
        scoreData.put("date", System.currentTimeMillis());
        scoreData.put("topic", getIntent().getStringExtra("TOPIC"));

        db.collection("history").add(scoreData)
                .addOnSuccessListener(documentReference -> {
                    // Score saved successfully
                    Log.d("ScoreSummaryActivity", "Score saved successfully");
                })
                .addOnFailureListener(e -> {
                    // Failed to save score
                    Log.d("ScoreSummaryActivity", "Failed to save score: " + e.getMessage());
                });
    }
}