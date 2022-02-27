package com.group.mathproject.service;

import com.group.mathproject.model.QuestionForm;
import com.group.mathproject.model.QuestionBoolForm;
import com.group.mathproject.model.Question;
import com.group.mathproject.model.UserQuestion;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    Question saveQuestion(Question question);
    List<Question> saveQuestions(List<Question> questions);
    List<Question> getAllQuestions();
    List<Question> getSomeQuestions(Integer numOfQuestions);
    List<Question> generateQuestions(List<QuestionForm> form);
    Optional<Question> findById(Integer id);
    void deleteQuestionById(Integer id);
    void deleteQuestion(Question question);
    Question getQuestionBySubject(String subject);
    List<Question> getQuestionsByUser(String username);
    List<UserQuestion> getUserQuestionsByUser(String username);
    Optional<UserQuestion> getUserQuestionById(Integer id);
    UserQuestion saveUserQuestion(UserQuestion userQuestion);
    List<Question> getTeacherMadeQuestions();
    Question saveQuestionToUser(String username, Question question);
    List<UserQuestion> addQuestionsToUser(List<QuestionBoolForm> qbf, String username);
}
