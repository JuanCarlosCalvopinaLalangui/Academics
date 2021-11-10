package pt.ipleiria.estg.dei.ei.dae.academics.entities;

import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "getAllStudents",
                query = "SELECT s FROM Student s ORDER BY s.name" // JPQL
        )
})

@Table(name = "Students")
public class Student implements Serializable {

    @Id
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    @Email
    private String email;
    @ManyToOne
    @JoinColumn(name = "COURSE_CODE")
    @NotNull
    private Course course;


    public Student() {
    }

    public Student(String username, String password, String name, String email, Course course) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String username) {
        this.username = username;
    }

    public String getId() {
        return username;
    }
}
