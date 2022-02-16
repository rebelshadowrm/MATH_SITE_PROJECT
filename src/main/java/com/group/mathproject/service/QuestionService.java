package com.group.mathproject.service;

import com.group.mathproject.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    Question saveQuestion(Question question);
    void createQuestions(List<Question> questions);
    List<Question> getAllQuestions();
    List<Question> getSomeQuestions(int numOfQuestions);
    Optional<Question> findById(int id);
    void deleteQuestionById(int id);
    void deleteQuestion(Question question);
}
