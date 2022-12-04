package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import java.util.List;

@Data
public class Course {
    private Long courseId;
    private String name;
    private String description;
    //lista sto gi cuva site studenti koi slusaat odreden kurs
    private List<Student> students = null;

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
