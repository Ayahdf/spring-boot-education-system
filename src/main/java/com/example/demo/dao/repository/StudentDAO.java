package com.example.demo.dao.repository;

import com.example.demo.dao.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDAO extends JpaRepository<Student,Integer> {
    public List<Student>findByName(String nom);
    public List<Student> findByMatricule(String matricule);

    public List<Student>deleteByName(String nom);
    public List<Student> deleteByMatricule(String matricule);
}
