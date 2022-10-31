package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CourseRepository {
    public static List<Course> courseList = new ArrayList<>(5);

    //gi vrakja site kursevi
    public List<Course> findAllCourses() {
        return courseList;
    }

    //go vrakja kursot so soodvetno id
    public Course findById(Long courseId) {
        return courseList.stream().filter(r->r.getCourseId().equals(courseId)).findFirst().get();
    }

    //?????????????????????
    //vrakja lista studenti sto slusaat odreden kurs
//    public List<Student> findAllStudentsByCourse(Long courseId) {
//        return courseList.stream().filter(r->r.getStudents().getClass().equals(courseId)).collect(Collectors.toList());
//    }

    //pravi dodavanje na nov student vo listata
    public Course addStudentToCourse(Student student, Course course){
        //ako ne postoi student
        if (student==null || student.getName()==null || student.getName().isEmpty()){
            return null;
        }
        //ako veke postoi studentot na toj kurs
        if (course.getStudents().equals(student)){
            return null;
        }
        //?????????????
//        course.setStudents();
        return course;
    }


}
