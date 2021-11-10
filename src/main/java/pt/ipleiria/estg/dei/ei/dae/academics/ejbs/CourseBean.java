package pt.ipleiria.estg.dei.ei.dae.academics.ejbs;

import pt.ipleiria.estg.dei.ei.dae.academics.entities.Course;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CourseBean {
    @PersistenceContext
    EntityManager entityManager;

    public void create(int code, String name){
        Course course = entityManager.find(Course.class,code);
        if ( course != null){
            System.out.println("Course already exist");
        }
        course = new Course(code,name);
        entityManager.persist(course);
    }

    public List<Course> getAllCourses() {
        return (List<Course>) entityManager.createNamedQuery("getAllCourses").getResultList();
    }

    public Course findCourseName(String name) {
        return entityManager.find(Course.class, name);
    }

    public Course findCourseCode(int code) {
        return entityManager.find(Course.class, code);
    }
}
