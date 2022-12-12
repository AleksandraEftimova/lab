package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
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
