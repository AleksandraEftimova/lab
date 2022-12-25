package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.StudentService;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/coursescontroller")
public class CourseController {

    private final CourseService courseService;
    private final StudentService studentService;
    private final TeacherService teacherService;

    public CourseController(CourseService courseService, StudentService studentService, TeacherService teacherService) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @GetMapping("/courses")
    public String getCoursesPage(@RequestParam(required = false) String error, Model model){
        List<Course> courses = this.courseService.listAll();
        model.addAttribute("courses", courses);
        return "listCourses";
    }

    @PostMapping("/courses/add")
    public String saveCourse(@RequestParam String name,
                             @RequestParam String description,
                             @RequestParam Long teacherId){
        this.courseService.save(name, description, teacherId);
        return "redirect:/listCourses";
    }

    @GetMapping("courses/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        this.courseService.deleteById(id);
        return "redirect:/listCourses";
    }

    @GetMapping("/add-form")
    public String addCoursePage(Model model){
        List<Student> students = this.studentService.listAll();
        List<Teacher> teachers = this.teacherService.findAll();
        model.addAttribute("students", students);
        model.addAttribute("teachers", teachers);
        return "addCourse";
    }

    //editing product
    @GetMapping("/edit-form/{id}")
    public String editCoursePage(@PathVariable Long id, Model model){
        //proverka dali tuka ima course so toj id, zemi go i povikaj get
        if (this.courseService.findById(id)!=null) {
            Course course = this.courseService.findById(id);

            List<Teacher> teachers = this.teacherService.findAll();

            model.addAttribute("teachers", teachers);
            model.addAttribute("course", course);

            return "addCourse";
        }
        //ako ne pa prikazi greska (tuka napravivme promena vo getProductPage pogore
        return "redirect:/listCourses";
    }

}
