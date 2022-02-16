package com.group.mathproject.controller;

import com.group.mathproject.exception.NotFoundException;
import com.group.mathproject.model.Question;
import com.group.mathproject.service.implementation.QuestionServiceImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//yo mama

@RestController
@RequestMapping("/api")
public class QuestionsController {

    private final QuestionServiceImpl questionServiceImpl;

    @Autowired
    public QuestionsController(QuestionServiceImpl questionServiceImpl) {
        this.questionServiceImpl = questionServiceImpl;
    }

    @GetMapping("/questions")
    public List<Question> getAllQuestions(){
        return questionServiceImpl.getAllQuestions();
    }

    @GetMapping("/questions/{num}")
    public List<Question> getSomeQuestions(@PathVariable("num") Integer number){
        return questionServiceImpl.getSomeQuestions(number);
    }

    @PostMapping("/questions")
    public Question addQuestion(@RequestBody Question question){
        return questionServiceImpl.saveQuestion(question);
    }

    @PutMapping("/questions/{id}")
    public Question updateQuestion(@PathVariable("id") int id,
                               @RequestBody @NotNull Question newQuestion) {
        Question qu = questionServiceImpl.findById(id)
                .orElseThrow( () -> new NotFoundException(
                        "Question with id of " + id + " not found!"
                ));

        qu.setQuestion(newQuestion.getQuestion());
        qu.setAnswers(newQuestion.getAnswers());
        qu.setDifficulty(newQuestion.getDifficulty());
        qu.setLevel(newQuestion.getLevel());

        return questionServiceImpl.saveQuestion(qu);
    }

    @DeleteMapping("/questions/{id}")
    public String deleteQuestion(@PathVariable("id") int id){
        Question qu = questionServiceImpl.findById(id)
                .orElseThrow( () -> new NotFoundException(
                        "Question with id of " + id + " not found!"
                ));
        questionServiceImpl.deleteQuestionById(qu.getId());
        return "Question with ID: " + id + " was deleted";
    }

}
