package com.example.demo.dao.repository;

import com.example.demo.dao.entities.Professor;
import com.example.demo.dao.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SessionDAO extends JpaRepository<Session,Integer> {
       public List<Session> findByDate(Date date);
       public List<Session>deleteByDate(Date date);
}
