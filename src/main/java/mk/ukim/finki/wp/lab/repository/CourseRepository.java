package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {
    List<Course> courses = new ArrayList<>(5);

    //gi vrakja site kursevi
    public List<Course> findAllCourses() {
//        return DataHolder.courses;
        return courses;
    }

    //go vrakja kursot so soodvetno id
    public Course findById(Long courseId) {
//        return DataHolder.courses.stream().filter(r -> r.getCourseId().equals(courseId)).findFirst().get();
        return courses.stream().filter(r -> r.getCourseId().equals(courseId)).findFirst().get();
    }

    //?????????????????????
    //vrakja lista studenti sto slusaat odreden kurs
    public List<Student> findAllStudentsByCourse(Long courseId) {
//        return courses.stream().filter(r->r.getCourseId().equals(courseId)).collect(Collectors.toList());
//        return DataHolder.courses.stream().filter(r->r.getStudents().equals(courseId).collect(Collectors.toList());
        List<Student> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getCourseId() == courseId){
                result.addAll(c.getStudents());
            }
        }
        return result;
    }

    //pravi dodavanje na nov student vo listata
    public Course addStudentToCourse(Student student, Course course){
        //ako ne postoi student
        if (student==null || student.getName()==null || student.getName().isEmpty() || course==null){
            return null;
        }
        //ako veke postoi studentot na toj kurs
        if (course.getStudents().equals(student)){
            return null;
        }
        Course temp = null;
        for (Course c : courses) {
            if (Objects.equals(c.getCourseId(), course.getCourseId())) {
                temp = c;
                c.getStudents().add(student);
            }
        }

        return temp;
    }


}
