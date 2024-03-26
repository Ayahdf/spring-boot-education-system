package com.example.demo.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
@Table(name= "Etudiant")
public class Student extends Person {
        @Column( name = " Matricule")
    private String matricule;

    @ManyToMany( mappedBy = "students" , fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<Session> sessions = new ArrayList<>();

    @Override
    public String toString() {
        return "Student{" +
                "matricule='" + matricule + '\'' +
                "} " + super.toString();
    }
}
