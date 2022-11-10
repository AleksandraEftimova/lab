package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Student> students = new ArrayList<>();
    public static List<Course> courses = new ArrayList<>();

    @PostConstruct
    public void init() {
        students.add(new Student("user", "pass", "name", "surname"));
        students.add(new Student("user1", "pass1", "name1", "surname1"));
        students.add(new Student("user2", "pass2", "name2", "surname2"));
        students.add(new Student("user3", "pass3", "name3", "surname3"));
        students.add(new Student("user4", "pass4", "name4", "surname4"));

        courses.add(new Course(1L, "Veb programiranje", "zimski predmet", students));
        courses.add(new Course(2L, "Operativni sistemi", "zimski predmet", students));
        courses.add(new Course(3L, "Elektronska i mobilna trgovija", "zimski predmet", students));
        courses.add(new Course(4L, "Kompjuterski mrezi", "zimski predmet", students));
    }
}
