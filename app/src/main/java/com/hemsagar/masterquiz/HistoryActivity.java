package com.hemsagar.masterquiz;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView historyRecyclerView;
    private HistoryAdapter historyAdapter;
    private List<HistoryItem> historyList;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        // Initialize Firestore
        db = FirebaseFirestore.getInstance();

        // Initialize UI elements
        historyRecyclerView = findViewById(R.id.historyRecyclerView);
        historyRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize history list and adapter
        historyList = new ArrayList<>();
        historyAdapter = new HistoryAdapter(historyList);
        historyRecyclerView.setAdapter(historyAdapter);

        // Fetch history from Firestore
        fetchHistoryFromFirestore();
    }

    private void fetchHistoryFromFirestore() {
        db.collection("history").get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            int score = document.getLong("score").intValue();
                            int totalQuestions = document.getLong("totalQuestions").intValue();
                            long date = document.getLong("date");

                            historyList.add(new HistoryItem(score, totalQuestions, date));
                        }
                        historyAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(this, "Failed to load history.", Toast.LENGTH_SHORT).show();
                        Log.d("HistoryActivity", "Error getting documents: ", task.getException());
                    }
                });
    }
}