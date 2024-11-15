package com.hemsagar.masterquiz;

public class Question {
    private String topic;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctAnswer;

    // Empty constructor for Firestore
    public Question() {}

    // Getter methods
    public String getTopic() { return topic; }
    public String getQuestion() { return question; }
    public String getOptionA() { return optionA; }
    public String getOptionB() { return optionB; }
    public String getOptionC() { return optionC; }
    public String getOptionD() { return optionD; }
    public String getCorrectAnswer() { return correctAnswer; }

    // Setter methods (if needed)
    public void setTopic(String topic) { this.topic = topic; }
    public void setQuestion(String question) { this.question = question; }
    public void setOptionA(String optionA) { this.optionA = optionA; }
    public void setOptionB(String optionB) { this.optionB = optionB; }
    public void setOptionC(String optionC) { this.optionC = optionC; }
    public void setOptionD(String optionD) { this.optionD = optionD; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }
}
