package pt.ipleiria.estg.dei.ei.dae.academics.ejbs;

import pt.ipleiria.estg.dei.ei.dae.academics.entities.Student;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StudentBean {
    @PersistenceContext
    EntityManager entityManager;

    public void create(Integer username, String password, String name, String email){
        Student student = new Student(username,password,name,email);
        entityManager.persist(student);
    }
}
