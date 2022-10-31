package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    public static List<Student> studentList = new ArrayList<>(5);

    //gi vrakja site studenti
    List<Student> findAllStudents(){
        return studentList;
    }

    //gi pronaogja po ime ili prezime i gi vrakja kako kolekcija, t.e. lista
    List<Student> findAllByNameOrSurname(String text){
        return studentList.stream().filter(r->r.getName().contains(text)
                || r.getSurname().contains(text)).collect(Collectors.toList());
    }
}
