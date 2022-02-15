package com.group.mathproject.service;

import com.group.mathproject.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    Question saveQuestion(Question question);
    void createQuestions(List<Question> questions);
    List<Question> getQuestions();
    Optional<Question> findById(Integer id);
    void deleteById(Integer id);
    void deleteQuestion(Question question);
}
