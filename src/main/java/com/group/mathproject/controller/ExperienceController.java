package com.group.mathproject.controller;

import com.group.mathproject.model.Experience;
import com.group.mathproject.service.ExperienceService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ExperienceController {
    private final ExperienceService experienceService;


    @GetMapping("/exp")
    public ResponseEntity<List<Experience>>getExp() {
        return ResponseEntity.ok().body(experienceService.getExperienceList());
    }

    @GetMapping("/exp/user/{username}")
    public Experience getExperienceByUsername(@PathVariable("username") String username) {
        return experienceService.getExperienceByUserName(username);
    }

    @GetMapping("/exp/id/{id}")
    public Experience getExperienceById(@PathVariable("id") Integer userId) {
        return experienceService.getExperienceByUserId(userId);
    }

    @PostMapping("/exp/save")
    public ResponseEntity<Experience> saveExperience(@RequestBody Experience exp) {
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/exp/save")
                .toUriString());
        return ResponseEntity.created(uri).body(experienceService.saveExperience(exp));
    }

    @PostMapping("/exp/addQuestion")
    public ResponseEntity<?>addQuestion(@RequestBody QuestionToExpForm form) {
        experienceService.addQuestionToExperience( form.getQuestionId(), form.getExperienceId());
        return ResponseEntity.ok().build();
    }


}

@Data
class QuestionToExpForm {
    private Integer questionId;
    private Integer experienceId;
}
