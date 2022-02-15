package com.group.mathproject.service.implementation;

import com.group.mathproject.model.Question;
import com.group.mathproject.repository.QuestionRepository;
import com.group.mathproject.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    @Override
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public void createQuestions(List<Question> questions){
        questionRepository.saveAll(questions);
    }

    @Override
    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(Integer id) {
        return questionRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        questionRepository.deleteById(id);
    }

    @Override
    public void deleteQuestion(Question question){
        questionRepository.delete(question);
    }
}