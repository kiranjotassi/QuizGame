package com.example.kiranjotassi.quizgame.model;

import java.util.ArrayList;

public class Question {
    private static String question;
    private boolean answer;

    public Question(String question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isAnswer() {
        return answer;
    }

    public static ArrayList<Question> getQuestions() {

        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question("Toronto is the Capital", false));
        questions.add(new Question("Canada is larger than the US", true));
        questions.add(new Question("Canada has two official languages", true));
        questions.add(new Question("Ontario is the largest province", false));
        questions.add(new Question("Canada is part of the US", false));

        return questions;

    }
    public static String displayQuestion(){
        question.toString();
        return question;
    }
}
