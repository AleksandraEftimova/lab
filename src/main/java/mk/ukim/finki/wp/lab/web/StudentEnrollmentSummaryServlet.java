package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "studentEnrollmentSummary", urlPatterns = "/studentEnrollmentSummary")
public class StudentEnrollmentSummaryServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final StudentService studentService;
    private final CourseService courseService;

    public StudentEnrollmentSummaryServlet(SpringTemplateEngine springTemplateEngine, StudentService studentService, CourseService courseService) {
        this.springTemplateEngine = springTemplateEngine;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    //da gi izlista site dodadeni studenti na daden kurs
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
//        String courseId = req.getParameter("courseId");
//        courseId=null;
//        try {
////            courseId = Long.parseLong(req.getSession().getAttribute("courseId").toString());
//            courseId = req.getSession().getAttribute("courseId").toString();
//        } catch (Exception e) {
//            resp.sendRedirect("/listCourses");
//            return;
//        }
//        Long courseId = null;
//        Course course = courseService.findById(courseId);
//        List<Student> students = courseService.listStudentsByCourse(courseId);
        List<Student> students = studentService.listAll();
        context.setVariable("students", students);
        List<Course> courses = courseService.listAll();
        context.setVariable("courses", courses);

        this.springTemplateEngine.process("/studentsInCourse.html", context, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
