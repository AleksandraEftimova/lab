package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Student> students = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.students.add(new Student("user", "pass", "name", "surname"));
        this.students.add(new Student("user1", "pass1", "name1", "surname1"));
        this.students.add(new Student("user2", "pass2", "name2", "surname2"));
    }
}
