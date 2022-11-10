package com.quizplus.tasktwo.Service;

import com.quizplus.tasktwo.Models.Course;
import com.quizplus.tasktwo.Rerpositry.CourseRepo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class CourseService {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();
    public static  CourseRepo courseRepo;
    public CourseService(){
        this.courseRepo =new CourseRepo(entityManager);
    }

    public List<Course> findall() {
        return courseRepo.finaAll();
    }

    public Course findById(int theId) {

        return courseRepo.findById(theId);
    }
    public void save(Course course){
        entityManager.getTransaction().begin();
        courseRepo.save(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void Update(Course course){
        entityManager.getTransaction().begin();
        entityManager.merge(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void deleateById(int theId) {
        EntityTransaction session = entityManager.getTransaction();
        session.begin();
        courseRepo.deleteById(theId);
        session.commit();



    }

}
