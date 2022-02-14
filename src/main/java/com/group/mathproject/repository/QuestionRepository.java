package com.group.mathproject.repository;

import com.group.mathproject.model.Message;
import com.group.mathproject.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
