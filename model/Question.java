package com.sample.model;

import java.io.Serializable;

public class Question implements Serializable {
    private String question;
    private String answer_one;
    private String answer_two;
    private String answer_three;

    public Question(String question, String answer_one, String answer_two, String answer_three) {
        this.question = question;
        this.answer_one = answer_one;
        this.answer_two = answer_two;
        this.answer_three = answer_three;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer_one() {
        return answer_one;
    }

    public void setAnswer_one(String answer_one) {
        this.answer_one = answer_one;
    }

    public String getAnswer_two() {
        return answer_two;
    }

    public void setAnswer_two(String answer_two) {
        this.answer_two = answer_two;
    }

    public String getAnswer_three() {
        return answer_three;
    }

    public void setAnswer_three(String answer_three) {
        this.answer_three = answer_three;
    }
}
