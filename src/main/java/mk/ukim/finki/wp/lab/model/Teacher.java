package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Teacher {

    private Long id;
    private String name;
    private String surname;

    private LocalDate dateOfEmployment;

    public Teacher(Long id, String name, String surname, LocalDate dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfEmployment = dateOfEmployment;
    }
}
