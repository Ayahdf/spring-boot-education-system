package com.example.demo.dao.repository;

import com.example.demo.dao.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDAO extends JpaRepository<Person,Integer> {
}
