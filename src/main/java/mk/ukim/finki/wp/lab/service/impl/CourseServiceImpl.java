package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.repository.CourseRepository;
import mk.ukim.finki.wp.lab.repository.StudentRepository;
import mk.ukim.finki.wp.lab.repository.TeacherRepository;
import mk.ukim.finki.wp.lab.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public CourseServiceImpl(CourseRepository courseRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return courseRepository.findAllStudentsByCourse(courseId);
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        Student student = studentRepository.findByUsername(username);
        Course course = courseRepository.findById(courseId);
        return courseRepository.addStudentToCourse(student, course);
    }

    @Override
    public Course findById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public List<Course> listAll() {
        return courseRepository.findAllCourses();
    }

    @Override
    public Optional<Course> save(String name, String description,
                                 Long teacherId) {
//        List<Teacher> teacherList = this.teacherRepository.findAll(); //.courseRepository.findById(courseId).getTeachers();
//        Teacher teacher = this.teacherRepository.findById(teacherId);
        List<Teacher> teachers = (List<Teacher>) teacherRepository.findById(teacherId);
        return this.courseRepository.save(name, description, teachers);
    }

    @Override
    public void deleteById(Long courseId) {
        this.courseRepository.deleteById(courseId);
    }
}
