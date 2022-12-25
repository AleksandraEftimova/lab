package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.List;

@Data
//@Entity
//@Table(name = "courses")
public class Course implements Comparable<Course>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String name;
    private String description;

    //lista sto gi cuva site studenti koi slusaat odreden kurs
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Student> students = null;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Teacher> teachers = null;

    @Enumerated(EnumType.STRING)
    private Type type;

    public Course(Long courseId, String name, String description, List<Student> students, List<Teacher> teachers) {
//        this.courseId = (long) (Math.random() * 1000);
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.students = students;
        this.teachers = teachers;
    }

    public void addStudent(Student s){
        this.students.add(s);
    }
    public Course(){}

    @Override
    public int compareTo(Course o) {
        return 0;
    }
}
