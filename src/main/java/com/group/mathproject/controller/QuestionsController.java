package com.group.mathproject.controller;

import com.group.mathproject.exception.NotFoundException;
import com.group.mathproject.model.Question;
import com.group.mathproject.model.UserQuestion;
import com.group.mathproject.service.QuestionService;
import com.group.mathproject.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//yo mama

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class QuestionsController {
    private final QuestionService questionService;

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return ResponseEntity.ok().body(questionService.getAllQuestions());
    }

    @GetMapping("/questions/{num}")
    public List<Question> getSomeQuestions(@PathVariable("num") Integer number){
        return questionService.getSomeQuestions(number);
    }

    @PostMapping("/questions/generate/{num}")
    public ResponseEntity<List<Question>> generateQuestions(
            @PathVariable("num") Integer number,
            @RequestBody QuestionForm form) {
        return ResponseEntity.ok()
                .body(questionService.generateQuestions(number,
                        form.getSubject(), form.getDifficulty()));
    }

    @GetMapping("/questions/user/{username}")
    public ResponseEntity<List<UserQuestion>> getQuestionsByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(questionService.getUserQuestionsByUser(username));
    }

    @PostMapping("/questions")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/questions")
                .toUriString());
        return ResponseEntity.created(uri).body(questionService.saveQuestion(question));
    }

    @PostMapping("/questions/{username}")
    public ResponseEntity<UserQuestion>addQuestionsToUser(
            @PathVariable("username") String username,
            @RequestBody List<QuestionBoolForm> qbf) {
        URI uri = URI.create(ServletUriComponentsBuilder
                     .fromCurrentContextPath()
                     .path("/api/questions")
                     .toUriString());

        return ResponseEntity.created(uri)
                             .body(questionService
                             .addQuestionToUser(qbf, username));
    }

    @PutMapping("/questions/{id}")
    public Question updateQuestion(@PathVariable("id") int id,
                               @RequestBody @NotNull Question newQuestion) {
        Question qu = questionService.findById(id)
                .orElseThrow( () -> new NotFoundException(
                        "Question with id of " + id + " not found!"
                ));
        qu.setQuestion(newQuestion.getQuestion());
        return questionService.saveQuestion(qu);
    }

    @DeleteMapping("/questions/{id}")
    public String deleteQuestion(@PathVariable("id") int id){
        Question qu = questionService.findById(id)
                .orElseThrow( () -> new NotFoundException(
                        "Question with id of " + id + " not found!"
                ));
        questionService.deleteQuestionById(qu.getId());
        return "Question with ID: " + id + " was deleted";
    }

}
@Data
class QuestionForm {
    String subject;
    Integer difficulty;
}

