package pt.ipleiria.estg.dei.ei.dae.academics.ejbs;

import pt.ipleiria.estg.dei.ei.dae.academics.entities.Course;
import pt.ipleiria.estg.dei.ei.dae.academics.entities.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StudentBean {
    @PersistenceContext
    EntityManager entityManager;

    public void create(String username, String password, String name, String email, int courseCode){
        Student student = entityManager.find(Student.class,username);
        if (student != null) {
            System.out.println("Student Already Exist");
        }
        Course course = entityManager.find(Course.class,courseCode);
        if ( course == null){
            System.out.println("Course not found");
        }
        student = new Student(username,password,name,email,course);
        course.addStudent(student);
        entityManager.persist(student);
    }

    public List<Student> getAllStudents() {
        return (List<Student>) entityManager.createNamedQuery("getAllStudents").getResultList();
    }

    public Student findStudent(String username) {
        return entityManager.find(Student.class, username);
    }
}
