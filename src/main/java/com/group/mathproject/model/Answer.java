package com.group.mathproject.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @Column(name = "answer_id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
    private String answer;
    private Boolean correct;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Answer answer = (Answer) o;
        return id != null && Objects.equals(id, answer.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}