package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.repository.StudentRepository;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    //dependancy injection
    private final StudentRepository studentRepository;
    public StudentServiceImpl (StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> listAll() {
        return studentRepository.findAllStudents();
    }

    @Override
    public List<Student> searchByNameOrSurname(String text) {
        return studentRepository.findAllByNameOrSurname(text);
    }


    @Override
    public Student save(String username, String password, String name, String surname) {
        if (username.isEmpty() || password.isEmpty() || name.isEmpty() || surname.isEmpty())
            return null;
        Student student = new Student(username, password, name, surname);
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student findByUsername(String username) {
        return studentRepository.findByUsername(username);
    }


}
