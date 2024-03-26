package com.example.demo;

import com.example.demo.dao.entities.*;
import com.example.demo.dao.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private CourseDAO courseDAO;
    @Autowired
    private ProfessorDAO professorDAO;
    @Autowired
    private SessionDAO sessionDAO;
    @Autowired
    private StudentDAO studentDAO;
    @Autowired
    private PersonDAO personDAO;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Create
       Student student = new Student();
        student.setName("Aya");
        student.setBirthday(new Date(2002,07,28));
        student.setMatricule("C2021-00700");
        personDAO.save(student);

       Student student2 = new Student();
        student2.setName("HDF");
        student2.setBirthday(new Date(2003,07,28));
        student2.setMatricule("C2021-00701");
        personDAO.save(student2);


       Professor professor = new Professor();
        professor.setName("M.HIRCHOUA");
        professor.setBirthday(new Date(1995,8,13));
        professor.setDateAssignment(new Date(2019,9,17));
        personDAO.save(professor);


       Course course = new Course();
        course.setTitle("JEE");
        course.setDescription("Dans ce cours nous etudions JEE");
        courseDAO.save(course);


       Session session1 = new Session();
        session1.setDate(new Date(2024,06,7));
        session1.setH_start(new Date(2024,02,03));
        session1.setH_end(new Date(2024,06,14));
        sessionDAO.save(session1);


       Session session2 = new Session();
        session2.setDate(new Date(2023,06,7));
        session2.setH_start(new Date(2023,02,03));
        session2.setH_end(new Date(2023,06,14));
        sessionDAO.save(session2);

        List<Session> sessions = new ArrayList<>();
        sessions.add(session1);
        sessions.add(session2);
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student2);

        professor.setCourse(course);
        course.setProfessor(professor);
        course.setSessions(sessions);
        session1.setCourse(course);
        session2.setCourse(course);
        session1.setStudents(students);
        session2.setStudents(students);
        student.setSessions(sessions);
        student2.setSessions(sessions);


        personDAO.save(student);
        personDAO.save(student2);
        personDAO.save(professor);
        courseDAO.save(course);
        sessionDAO.save(session1);
        sessionDAO.save(session2);


        //Read
       List<Student> listStudents = studentDAO.findAll();
       listStudents.forEach(studentFromList ->{
           System.out.println(studentFromList.toString());
       });
       List<Course> listCourses = courseDAO.findAll();
       listCourses.forEach(courseFromList ->{
           System.out.println(courseFromList.toString());
       });
       List<Professor> listProfessors = professorDAO.findAll();
       listProfessors.forEach(professorFromList ->{
           System.out.println(professorFromList.toString());
       });
       List<Session> listSessions = sessionDAO.findAll();
       listSessions.forEach(sessionFromList ->{
           System.out.println(sessionFromList.toString());
       });
         //update
       student.setName("HOUDAIFA");
       personDAO.save(student);
       professor.setBirthday(new Date(1997,12,13));
       personDAO.save(professor);
       course.setDescription("Mise a jour du cours JEE");
       courseDAO.save(course);
       session1.setDate(new Date(2024,06,19));
       sessionDAO.save(session1);
        //Read after update
       List<Student> listStudents2 = studentDAO.findAll();
       listStudents2.forEach(studentFromList ->{
             System.out.println(studentFromList.toString());
            });
       List<Course> listCourses2 = courseDAO.findAll();
        listCourses2.forEach(courseFromList ->{
                System.out.println(courseFromList.toString());
            });
       List<Professor> listProfessors2 = professorDAO.findAll();
       listProfessors2.forEach(professorFromList ->{
                System.out.println(professorFromList.toString());
            });
       List<Session> listSessions2 = sessionDAO.findAll();
       listSessions2.forEach(sessionFromList ->{
                System.out.println(sessionFromList.toString());
            });

        //delete

        courseDAO.deleteById(1);
        try {
            System.out.println(courseDAO.findById(1).get());

        } catch (Exception exception) {
            System.out.println("The course has been deleted");}

        personDAO.deleteById(1);
        try {
            System.out.println(personDAO.findById(1).get());

        } catch (Exception exception) {
            System.out.println("The person has been deleted");}

        sessionDAO.deleteById(1);
        try {
            System.out.println(sessionDAO.findById(1).get());

        } catch (Exception exception) {
            System.out.println("The session has been deleted");}


    }
}
