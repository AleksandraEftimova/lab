package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {

    //gi vrakja site kursevi
    public List<Course> findAllCourses() {
        return DataHolder.courses;
    }

    //go vrakja kursot so soodvetno id
    public Course findById(Long courseId) {
        return DataHolder.courses
                .stream()
                .filter(r -> r.getCourseId().equals(courseId))
                .findFirst().get();
    }


    //vrakja lista studenti sto slusaat odreden kurs
    public List<Student> findAllStudentsByCourse(Long courseId){
        return DataHolder.courses
                .stream()
                .filter(r->r.getCourseId().equals(courseId))
                .findFirst().get().getStudents();
    }

    public Course addStudentToCourse(Student student, Course course){
        findById(course.getCourseId()).addStudent(student);
        return findById(course.getCourseId());
    }

    public Optional<Course> save(String name, String description,
                                 List<Teacher> teachers) {

        DataHolder.courses.removeIf(r->r.getName().equals(name) || r.getDescription().equals(description));

        Long courseId = DataHolder.courses
                .stream()
                .filter(r->r.getName().equals(name) && r.getDescription().equals(description))
                .findFirst().get().getCourseId();
        List<Student> students = DataHolder.students;

        Course course = new Course(courseId, name, description, students, teachers);
        DataHolder.courses.add(course);
        return Optional.of(course);
    }

    public void deleteById(Long courseId) {
        DataHolder.courses.removeIf(r->r.getCourseId().equals(courseId));
    }
}