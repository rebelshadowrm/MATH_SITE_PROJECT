package com.group.mathproject.controller;

import com.group.mathproject.model.Question;
import com.group.mathproject.service.implementation.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionsController {

    private final QuestionServiceImpl questionServiceImpl;

    @Autowired
    public QuestionsController(QuestionServiceImpl questionServiceImpl) {
        this.questionServiceImpl = questionServiceImpl;
    }

    @GetMapping("/test")
    public List<Question> getTest(){
        return questionServiceImpl.getQuestions();
    }

    @GetMapping("/questions/{num}")
    public List<Question> getQuestions(@PathVariable("num") Integer number){
        return questionServiceImpl.getQuestions();
    }


}
