package com.hemsagar.masterquiz;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Setting up the topic cards
        CardView natureCard = findViewById(R.id.cardNature);
        CardView scienceCard = findViewById(R.id.cardScience);
        CardView csCard = findViewById(R.id.cardCS);

        // Setting up onClickListeners for each card
        natureCard.setOnClickListener(v -> openQuizScreen("Nature"));
        scienceCard.setOnClickListener(v -> openQuizScreen("Science"));
        csCard.setOnClickListener(v -> openQuizScreen("Computer Science"));
    }

    private void openQuizScreen(String topic) {
        Intent quizIntent = new Intent(HomeActivity.this, QuizActivity.class);
        quizIntent.putExtra("TOPIC", topic);
        startActivity(quizIntent); // Start QuizActivity with topic data
    }

    // Inflate the menu with a history option
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    // Handle menu item clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.history) {
            Intent historyIntent = new Intent(this, HistoryActivity.class);
            startActivity(historyIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
