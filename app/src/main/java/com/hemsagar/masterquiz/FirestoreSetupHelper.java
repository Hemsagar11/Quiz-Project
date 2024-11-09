package com.hemsagar.masterquiz;

import android.util.Log;

import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class FirestoreSetupHelper {

    private FirebaseFirestore db;

    public FirestoreSetupHelper() {
        db = FirebaseFirestore.getInstance();
    }

    public void setupFirestoreData() {
        // Add Nature questions
        addNatureQuestions();
        // Add Science questions
        addScienceQuestions();
        // Add Computer Science questions
        addComputerScienceQuestions();
    }

    private void addNatureQuestions() {
        String topic = "Nature";

        Map<String, Object> question1 = new HashMap<>();
        question1.put("topic", "Nature");
        question1.put("question", "What is the largest mammal?");
        question1.put("optionA", "Elephant");
        question1.put("optionB", "Blue Whale");
        question1.put("optionC", "Giraffe");
        question1.put("optionD", "Shark");
        question1.put("correctAnswer", "Blue Whale");
        addQuestionToFirestore(question1);

        Map<String, Object> question2 = new HashMap<>();
        question2.put("topic", "Nature");
        question2.put("question", "Which of these animals can fly?");
        question2.put("optionA", "Elephant");
        question2.put("optionB", "Penguin");
        question2.put("optionC", "Bat");
        question2.put("optionD", "Lion");
        question2.put("correctAnswer", "Bat");
        addQuestionToFirestore(question2);

        Map<String, Object> question3 = new HashMap<>();
        question3.put("topic", "Nature");
        question3.put("question", "Which tree produces acorns?");
        question3.put("optionA", "Pine");
        question3.put("optionB", "Oak");
        question3.put("optionC", "Maple");
        question3.put("optionD", "Birch");
        question3.put("correctAnswer", "Oak");
        addQuestionToFirestore(question3);

        Map<String, Object> question4 = new HashMap<>();
        question4.put("topic", "Nature");
        question4.put("question", "What is the fastest land animal?");
        question4.put("optionA", "Cheetah");
        question4.put("optionB", "Lion");
        question4.put("optionC", "Elephant");
        question4.put("optionD", "Tiger");
        question4.put("correctAnswer", "Cheetah");
        addQuestionToFirestore(question4);

        Map<String, Object> question5 = new HashMap<>();
        question5.put("topic", "Nature");
        question5.put("question", "Which animal is known for its long neck?");
        question5.put("optionA", "Giraffe");
        question5.put("optionB", "Elephant");
        question5.put("optionC", "Zebra");
        question5.put("optionD", "Horse");
        question5.put("correctAnswer", "Giraffe");
        addQuestionToFirestore(question5);

        Map<String, Object> question6 = new HashMap<>();
        question6.put("topic", "Nature");
        question6.put("question", "What is the process by which plants make their food?");
        question6.put("optionA", "Respiration");
        question6.put("optionB", "Transpiration");
        question6.put("optionC", "Photosynthesis");
        question6.put("optionD", "Digestion");
        question6.put("correctAnswer", "Photosynthesis");
        addQuestionToFirestore(question6);

    }

    private void addScienceQuestions() {
        String topic = "Science";

        Map<String, Object> question1 = new HashMap<>();
        question1.put("topic", "Science");
        question1.put("question", "What is the chemical symbol for water?");
        question1.put("optionA", "H2O");
        question1.put("optionB", "O2");
        question1.put("optionC", "CO2");
        question1.put("optionD", "NaCl");
        question1.put("correctAnswer", "H2O");
        addQuestionToFirestore(question1);

        Map<String, Object> question2 = new HashMap<>();
        question2.put("topic", "Science");
        question2.put("question", "What planet is known as the Red Planet?");
        question2.put("optionA", "Earth");
        question2.put("optionB", "Mars");
        question2.put("optionC", "Venus");
        question2.put("optionD", "Jupiter");
        question2.put("correctAnswer", "Mars");
        addQuestionToFirestore(question2);

        Map<String, Object> question3 = new HashMap<>();
        question3.put("topic", "Science");
        question3.put("question", "What is the atomic number of carbon?");
        question3.put("optionA", "6");
        question3.put("optionB", "12");
        question3.put("optionC", "8");
        question3.put("optionD", "16");
        question3.put("correctAnswer", "6");
        addQuestionToFirestore(question3);

        Map<String, Object> question4 = new HashMap<>();
        question4.put("topic", "Science");
        question4.put("question", "Which gas do plants absorb from the air for photosynthesis?");
        question4.put("optionA", "Oxygen");
        question4.put("optionB", "Carbon Dioxide");
        question4.put("optionC", "Nitrogen");
        question4.put("optionD", "Helium");
        question4.put("correctAnswer", "Carbon Dioxide");
        addQuestionToFirestore(question4);

        Map<String, Object> question5 = new HashMap<>();
        question5.put("topic", "Science");
        question5.put("question", "What type of energy does a battery store?");
        question5.put("optionA", "Chemical Energy");
        question5.put("optionB", "Electrical Energy");
        question5.put("optionC", "Thermal Energy");
        question5.put("optionD", "Mechanical Energy");
        question5.put("correctAnswer", "Chemical Energy");
        addQuestionToFirestore(question5);

        Map<String, Object> question6 = new HashMap<>();
        question6.put("topic", "Science");
        question6.put("question", "Who is known as the father of modern physics?");
        question6.put("optionA", "Isaac Newton");
        question6.put("optionB", "Albert Einstein");
        question6.put("optionC", "Nikola Tesla");
        question6.put("optionD", "Galileo Galilei");
        question6.put("correctAnswer", "Albert Einstein");
        addQuestionToFirestore(question6);

    }

    private void addComputerScienceQuestions() {
        String topic = "Computer Science";

        Map<String, Object> question1 = new HashMap<>();
        question1.put("topic", "Computer Science");
        question1.put("question", "What does CPU stand for?");
        question1.put("optionA", "Central Processing Unit");
        question1.put("optionB", "Computer Personal Unit");
        question1.put("optionC", "Central Power Unit");
        question1.put("optionD", "Central Processor Unit");
        question1.put("correctAnswer", "Central Processing Unit");
        addQuestionToFirestore(question1);

        Map<String, Object> question2 = new HashMap<>();
        question2.put("topic", "Computer Science");
        question2.put("question", "Which programming language is primarily used for Android development?");
        question2.put("optionA", "Python");
        question2.put("optionB", "Java");
        question2.put("optionC", "JavaScript");
        question2.put("optionD", "C++");
        question2.put("correctAnswer", "Java");
        addQuestionToFirestore(question2);

        Map<String, Object> question3 = new HashMap<>();
        question3.put("topic", "Computer Science");
        question3.put("question", "What is the full form of HTML?");
        question3.put("optionA", "HyperText Markup Language");
        question3.put("optionB", "HyperTransfer Markup Language");
        question3.put("optionC", "Home Tool Markup Language");
        question3.put("optionD", "HyperTextual Media Language");
        question3.put("correctAnswer", "HyperText Markup Language");
        addQuestionToFirestore(question3);

        Map<String, Object> question4 = new HashMap<>();
        question4.put("topic", "Computer Science");
        question4.put("question", "Which of these is an example of an operating system?");
        question4.put("optionA", "Windows");
        question4.put("optionB", "Python");
        question4.put("optionC", "Java");
        question4.put("optionD", "MySQL");
        question4.put("correctAnswer", "Windows");
        addQuestionToFirestore(question4);

        Map<String, Object> question5 = new HashMap<>();
        question5.put("topic", "Computer Science");
        question5.put("question", "What does SQL stand for?");
        question5.put("optionA", "Structured Query Language");
        question5.put("optionB", "Sequential Query Language");
        question5.put("optionC", "Standard Question Language");
        question5.put("optionD", "Structured Question Language");
        question5.put("correctAnswer", "Structured Query Language");
        addQuestionToFirestore(question5);

        Map<String, Object> question6 = new HashMap<>();
        question6.put("topic", "Computer Science");
        question6.put("question", "What is the primary purpose of an algorithm?");
        question6.put("optionA", "To process data");
        question6.put("optionB", "To perform calculations");
        question6.put("optionC", "To provide a solution to a problem");
        question6.put("optionD", "To sort data");
        question6.put("correctAnswer", "To provide a solution to a problem");
        addQuestionToFirestore(question6);

    }

    private void addQuestionToFirestore(Map<String, Object> questionData) {
        db.collection("questions")
                .add(questionData)
                .addOnSuccessListener(documentReference -> {
                    // Log success or perform any action if needed
                    Log.d("FirestoreSetupHelper", "DocumentSnapshot added with ID: " + documentReference.getId());
                })
                .addOnFailureListener(e -> {
                    // Log or handle failure
                    Log.d("FirestoreSetupHelper", "Error adding document", e);
                });
    }
}
