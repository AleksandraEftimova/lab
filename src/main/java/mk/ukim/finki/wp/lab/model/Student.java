package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private String username;
    private String password;
    private String name;
    private String surname;

    private List<Grade> grades;

    public Student(String username, String password, String name, String surname){//, List<Grade> grades) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.grades = grades;
    }

}
