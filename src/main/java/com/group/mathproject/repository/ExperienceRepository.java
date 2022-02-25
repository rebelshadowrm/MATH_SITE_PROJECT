package com.group.mathproject.repository;

import com.group.mathproject.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
    Experience findByUserId(Integer user_id);
}
