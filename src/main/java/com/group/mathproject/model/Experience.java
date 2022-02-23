package com.group.mathproject.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Experience {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Integer experience;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
