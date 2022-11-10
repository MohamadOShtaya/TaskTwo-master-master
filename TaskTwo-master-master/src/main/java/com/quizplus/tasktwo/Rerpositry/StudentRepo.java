package com.quizplus.tasktwo.Rerpositry;

import com.quizplus.tasktwo.Models.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class StudentRepo {
    public static EntityManager entityManager;
    public StudentRepo(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    public List<Student> finaAll() {
       List<Student>  students = entityManager.createQuery("from student").getResultList();

        return students;
    }
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    public Student findById(int theId) {
        Student student = entityManager.find(Student.class,theId);
        return student;

    }
    public void deleteById(int courseId){

        try {
            Student student = entityManager.find(Student.class,courseId);
            entityManager.remove(student);
            System.out.println("Deleated");
        }
        catch (Exception ex){
            System.out.println("student has already been Deleated ");
        }
    }
}
