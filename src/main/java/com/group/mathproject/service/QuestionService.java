package com.group.mathproject.service;

import com.group.mathproject.model.Question;
import com.group.mathproject.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepo){
        this.questionRepository = questionRepo;
    }

    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }

    public void createQuestions(List<Question> questions){
        questionRepository.saveAll(questions);
    }

    public void updateQuestion(int id, Question question){
        var updateQ = questionRepository.findById(id);

    }

    public void deleteQuestion(Question question){
        questionRepository.delete(question);
    }
}