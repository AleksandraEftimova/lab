package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
//@Entity
//@Table(name = "students")
public class Student {

    @Id
    private String username;
    private String password;
    private String name;
    private String surname;

    @OneToMany
    private List<Grade> grades;

    public Student(String username, String password, String name, String surname){//, List<Grade> grades) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.grades = grades;
    }

}
