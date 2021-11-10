package pt.ipleiria.estg.dei.ei.dae.academics.entities;

import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(
        name = "COURSES",
        uniqueConstraints = @UniqueConstraint(columnNames = {"NAME"})
)
@NamedQueries({
        @NamedQuery(
                name = "getAllCourses",
                query = "SELECT c FROM Course c ORDER BY c.name" // JPQL
        )
})
public class Course {
    @Id
    private int code;
    @NotNull
    private String name;
    @OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE)
    private List<Student> students;

    public Course() {
        this.students = new LinkedList<>();
    }

    public Course(int code, String name) {
        this.code = code;
        this.name = name;
        this.students = new LinkedList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(Student student){
        students.remove(student);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
