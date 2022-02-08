package com.sample.model;

import java.io.Serializable;
import java.util.List;

public class Quiz implements Serializable {
    private String name;
    private List<Question> questionList;

    public Quiz() {
    }

    public Quiz(String name, List<Question> questionList) {
        this.name = name;
        this.questionList = questionList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
