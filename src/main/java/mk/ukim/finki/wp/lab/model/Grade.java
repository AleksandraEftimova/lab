package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Grade {
    private Long id;
    private Character grade;
    private Student student;
    private Course course;
    private LocalDateTime timestamp;

    public Grade(Long id, Character grade, Student student, Course course, LocalDateTime timestamp) {
        this.id = id;
        this.grade = grade;
        this.student = student;
        this.course = course;
        this.timestamp = timestamp;
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
}
