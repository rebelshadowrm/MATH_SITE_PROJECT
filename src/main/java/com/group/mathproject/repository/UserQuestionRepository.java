package com.group.mathproject.repository;

import com.group.mathproject.model.User;
import com.group.mathproject.model.UserQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserQuestionRepository extends JpaRepository<UserQuestion, Integer> {
    List<UserQuestion> findUserQuestionsByUser(User user);
}
