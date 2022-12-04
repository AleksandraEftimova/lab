//package mk.ukim.finki.wp.lab.web;
//
//
//import mk.ukim.finki.wp.lab.model.Course;
//import mk.ukim.finki.wp.lab.model.Student;
//import mk.ukim.finki.wp.lab.service.CourseService;
//import mk.ukim.finki.wp.lab.service.StudentService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name = "allStudentsAndCourses", urlPatterns = "/allStudentsAndCourses")
//public class AllStudentsAndCoursesServlet extends HttpServlet {
//    private final SpringTemplateEngine springTemplateEngine;
//    private final StudentService studentService;
//    private final CourseService courseService;
//
//    public AllStudentsAndCoursesServlet(SpringTemplateEngine springTemplateEngine, StudentService studentService, CourseService courseService) {
//        this.springTemplateEngine = springTemplateEngine;
//        this.studentService = studentService;
//        this.courseService = courseService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        WebContext context = new WebContext(req,resp,req.getServletContext());
//
//        List<Student> students = studentService.listAll();
//        context.setVariable("students", students);
//
//        List<Course> courses = (List<Course>) courseService.listAll();
//        context.setVariable("courses", courses);
//
//        this.springTemplateEngine.process("AllStudentsAndCourses.html", context, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }
//}
