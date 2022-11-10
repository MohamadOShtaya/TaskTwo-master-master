package com.quizplus.tasktwo.Rerpositry;

import com.quizplus.tasktwo.Models.Course;
import com.quizplus.tasktwo.Service.CourseService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CourseRepo {

    private static EntityManager entityManager;
    public CourseRepo(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    public List<Course> finaAll() {
        List<Course> courses =  entityManager.createQuery("from course").getResultList();
        return courses;
    }
    public void save(Course theCourse) {

        try {
            entityManager.persist(theCourse);
        }
        catch (Exception ex){
            entityManager.getTransaction().rollback();
        }

    }

    public Course findById(int theId) {
        Course course = entityManager.find(Course.class,theId);
        return course;

    }
    public void Put(Course course){
       entityManager.merge(course);
    }
    public void deleteById(int courseId){


        try {
            Course course = entityManager.find(Course.class,courseId);
            entityManager.remove(course);

            System.out.println("Deleated");
        }
        catch (Exception ex){
            System.out.println("Course has already been delated ");
            entityManager.getTransaction().rollback();
        }

    }
}
