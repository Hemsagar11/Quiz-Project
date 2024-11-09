package com.hemsagar.masterquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView questionText, timerText, scoreText;
    private RadioGroup optionsGroup;
    private RadioButton option1, option2, option3, option4;
    private FirebaseFirestore db;
    private List<Question> questionsList = new ArrayList<>();
    private int currentQuestionIndex = 0;
    private int score = 0;
    private CountDownTimer countDownTimer;
    private static final int QUESTION_TIME_LIMIT = 15000; // 15 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Initialize Firestore
        db = FirebaseFirestore.getInstance();

        // UI elements
        questionText = findViewById(R.id.questionText);
        timerText = findViewById(R.id.timerText);
        scoreText = findViewById(R.id.scoreText);
        optionsGroup = findViewById(R.id.optionsGroup);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        // Retrieve selected topic
        String selectedTopic = getIntent().getStringExtra("TOPIC");

        // Fetch questions from Firestore based on the selected topic
        fetchQuestions(selectedTopic);
    }

    private void fetchQuestions(String topic) {
        CollectionReference questionsRef = db.collection("questions");

        questionsRef.whereEqualTo("topic", topic).get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        QuerySnapshot snapshot = task.getResult();
                        for (QueryDocumentSnapshot document : snapshot) {
                            // Create a Question object from Firestore document
                            Question question = document.toObject(Question.class);
                            questionsList.add(question);
                        }
                        Collections.shuffle(questionsList); // Shuffle questions
                        if (questionsList.size() > 5) {
                            questionsList = questionsList.subList(0, 5); // Select 5 random questions
                        }
                        displayQuestion();
                    } else {
                        Toast.makeText(this, "Failed to load questions.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questionsList.size()) {
            Question currentQuestion = questionsList.get(currentQuestionIndex);

            // Set question text
            questionText.setText(currentQuestion.getQuestion());

            // Set options
            option1.setText(currentQuestion.getOptionA());
            option2.setText(currentQuestion.getOptionB());
            option3.setText(currentQuestion.getOptionC());
            option4.setText(currentQuestion.getOptionD());

            // Clear previous selection and start timer for the question
            optionsGroup.clearCheck();
            startTimer();

            // Set listener for answer selection
            optionsGroup.setOnCheckedChangeListener((group, checkedId) -> {
                if (checkedId != -1) {
                    checkAnswer(currentQuestion, checkedId);
                }
            });
        } else {
            endQuiz();
        }
    }


    private void startTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        countDownTimer = new CountDownTimer(QUESTION_TIME_LIMIT, 1000) {
            public void onTick(long millisUntilFinished) {
                timerText.setText("Time left: " + millisUntilFinished / 1000 + "s");
            }

            public void onFinish() {
                timerText.setText("Time's up!");
                moveToNextQuestion();
            }
        }.start();
    }

    private void checkAnswer(Question question, int selectedOptionId) {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        // Disable further selection
        optionsGroup.setOnCheckedChangeListener(null);

        // Get the selected answer text
        RadioButton selectedRadioButton = findViewById(selectedOptionId);
        String selectedAnswer = selectedRadioButton.getText().toString();

        // Check if the selected answer is correct
        if (selectedAnswer.equals(question.getCorrectAnswer())) {
            score++;
            scoreText.setText("Score: " + score);
        }

        // Move to the next question after a short delay
        optionsGroup.postDelayed(this::moveToNextQuestion, 500);
    }

    private void moveToNextQuestion() {
        currentQuestionIndex++;
        displayQuestion();
    }

    private void endQuiz() {
        Intent intent = new Intent(QuizActivity.this, ScoreSummaryActivity.class);
        intent.putExtra("SCORE", score);
        intent.putExtra("TOTAL_QUESTIONS", questionsList.size());
        startActivity(intent);
        finish();
    }
}
