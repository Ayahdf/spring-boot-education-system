package com.example.demo.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
@Table(name = "Professeur")
public class Professor extends Person{

    @Column(name = "d_affectation")
    private Date dateAssignment;

    @OneToOne(mappedBy = "professor")
    private Course course;

    @Override
    public String toString() {
        return "Professor{" +
                "dateAssignment=" + dateAssignment +
                ", course=" + course +
                "} " + super.toString();
    }

}
