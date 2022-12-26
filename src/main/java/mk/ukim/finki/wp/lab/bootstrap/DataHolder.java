package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Student> students = new ArrayList<>(5);
    public static List<Course> courses = new ArrayList<>(5);

    public static List<Teacher> teachers = new ArrayList<>();

    public static List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        students.add(new Student("Student1", "pass1", "name1", "surname1"));
        students.add(new Student("Student2", "pass2", "name2", "surname2"));
        students.add(new Student("Student3", "pass3", "name3", "surname3"));
        students.add(new Student("Student4", "pass4", "name4", "surname4"));
        students.add(new Student("Student5", "pass5", "name5", "surname5"));


        teachers.add(new Teacher(1L, "Teacher1", "Surname1", LocalDate.parse("01-01-2020")));
        teachers.add(new Teacher(2L, "Teacher2", "Surname2", LocalDate.parse("10-10-2020")));

        courses.add(new Course(1L, "Veb programiranje", "zimski predmet", students, teachers));
        courses.add(new Course(2L, "Operativni sistemi", "zimski predmet", students, teachers));
        courses.add(new Course(3L, "Elektronska i mobilna trgovija", "zimski predmet", students, teachers));
        courses.add(new Course(4L, "Kompjuterski mrezi", "zimski predmet", students, teachers));
    }
}
