package com.quizplus.tasktwo.Service;

import com.quizplus.tasktwo.Models.Student;
import com.quizplus.tasktwo.Rerpositry.StudentRepo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
public class StudentService {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();
    public static StudentRepo studentRepo;

    public StudentService() {

        this.studentRepo = new StudentRepo(entityManager);
    }
    public List<Student> findall() {
        return studentRepo.finaAll();
    }
    public Student findById(int theId) {
        return studentRepo.findById(theId);
    }
    public void save(Student theStudent) {
        entityManager.getTransaction().begin();
        studentRepo.save(theStudent);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void Update(Student theStudent) {
        entityManager.getTransaction().begin();
        entityManager.merge(theStudent);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void deleateById(int id){

        EntityTransaction session = entityManager.getTransaction();
        session.begin();
        studentRepo.deleteById(id);
        session.commit();



    }

}
