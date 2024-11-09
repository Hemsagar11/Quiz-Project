package com.hemsagar.masterquiz;

public class HistoryItem {
    private int score;
    private int totalQuestions;
    private long date;

    public HistoryItem(int score, int totalQuestions, long date) {
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public long getDate() {
        return date;
    }
}