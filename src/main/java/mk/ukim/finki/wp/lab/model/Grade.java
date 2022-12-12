package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Table(name = "grade")
public class Grade {

    @Id
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
