package com.example.demo.dao.repository;

import com.example.demo.dao.entities.Course;
import com.example.demo.dao.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProfessorDAO extends JpaRepository<Professor,Integer> {
    public List<Professor> findByName(String nom);
    public List<Professor> findByDateAssignment (Date d_assignment);
    public List<Professor> deleteByDateAssignment (Date d_assignment);
    public List<Professor>deleteByName(String nom);

}
