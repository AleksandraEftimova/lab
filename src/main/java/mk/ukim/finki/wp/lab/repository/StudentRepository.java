package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    List<Student> students = new ArrayList<>(5);

    //nepotrebno mozda????????????
//    public Student saveStudent(Student s) {
//        if (s==null || s.getName()==null || s.getName().isEmpty()) {
//            return null;
//        }
//        DataHolder.students.removeIf(r->r.getUsername().equals(s.getUsername()));
//        DataHolder.students.add(s);
//        return s;
//    }
//    public void delete(String username) {
//        if (username==null){
//            return;
//        }
//        DataHolder.students.removeIf(r->r.getUsername().equals(username));
//    }

    //gi vrakja site studenti
    public List<Student> findAllStudents(){
//        return studentList;
        return this.students;
    }

    //gi pronaogja po ime ili prezime i gi vrakja kako kolekcija, t.e. lista
    public List<Student> findAllByNameOrSurname(String text){
        return this.students.stream().filter(r->r.getName().contains(text)
                || r.getSurname().contains(text)).collect(Collectors.toList());
    }
}
