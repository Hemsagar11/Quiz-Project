package com.hemsagar.masterquiz;

public class HistoryItem {
    private int score;
    private int totalQuestions;
    private long date;
    private String topic;

    public HistoryItem(int score, int totalQuestions, long date, String Topic) {
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.date = date;
        this.topic = Topic;
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

    public String getTopic() {
        return topic;
    }
}