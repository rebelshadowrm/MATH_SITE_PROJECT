package com.group.mathproject.service;

import com.group.mathproject.controller.QuestionBoolForm;
import com.group.mathproject.model.Question;
import com.group.mathproject.model.UserQuestion;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    Question saveQuestion(Question question);
    List<Question> saveQuestions(List<Question> questions);
    List<Question> getAllQuestions();
    List<Question> getSomeQuestions(int numOfQuestions);
    List<Question> generateQuestions(Integer number, String Subject, Integer Difficulty);
    Optional<Question> findById(int id);
    void deleteQuestionById(int id);
    void deleteQuestion(Question question);
    Question getQuestionBySubject(String subject);
    List<Question> getQuestionsByUser(String username);
    List<UserQuestion> getUserQuestionsByUser(String username);
    List<UserQuestion> addQuestionToUser(List<QuestionBoolForm> qbf, String username);
}
