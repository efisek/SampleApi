package com.sample.controller;


import com.sample.entity.QuizEntity;
import com.sample.model.Quiz;
import com.sample.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/")
    public List<Quiz> getAllQuiz(){
        return quizService.getAllQuiz();
    }

    @GetMapping("/{quizId}")
    public Quiz getQuizById(@PathVariable Long quizId){
        return quizService.getQuizById(quizId);
    }
}
