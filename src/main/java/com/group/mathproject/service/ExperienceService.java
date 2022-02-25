package com.group.mathproject.service;

import com.group.mathproject.model.Experience;
import com.group.mathproject.model.Question;

import java.util.List;

public interface ExperienceService {
    Experience saveExperience(Experience experience);
    void addQuestionToExperience(Integer questionId, Integer experienceId);
    Experience getExperienceByUserId(Integer userId);
    Experience getExperienceByUserName(String username);
    List<Experience> getExperienceList();
}
