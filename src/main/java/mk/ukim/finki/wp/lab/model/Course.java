package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "courses")
public class Course {
    @Id
    private Long courseId;
    private String name;
    private String description;

    //lista sto gi cuva site studenti koi slusaat odreden kurs
    @ManyToMany
    private List<Student> students = null;

    @ManyToMany
    private List<Teacher> teachers = null;

    public Course(Long courseId, String name, String description, List<Student> students) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.students = students;
    }

    public void addStudent(Student s) {
        this.students.add(s);
    }
}
