package com.example.demo.dao.repository;

import com.example.demo.dao.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseDAO extends JpaRepository<Course, Integer> {
    public List<Course>findByTitle(String titre);
    public List<Course> findByDescription(String desc);

    public List<Course>deleteByTitle(String titre);
    public List<Course>deleteByDescription(String desc);
}
