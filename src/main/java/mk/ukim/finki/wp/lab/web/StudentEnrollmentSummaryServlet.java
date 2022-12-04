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

@WebServlet(name="StudentEnrollmentSummaryServlet", urlPatterns = "/studentEnroll")
public class StudentEnrollmentSummaryServlet  extends HttpServlet {

    //zavisnosti
    private final SpringTemplateEngine springTemplateEngine;
    private final StudentService studentService;
    private final CourseService courseService;

    public StudentEnrollmentSummaryServlet(SpringTemplateEngine springTemplateEngine, StudentService studentService, CourseService courseService) {
        this.springTemplateEngine = springTemplateEngine;
        this.studentService = studentService;
        this.courseService = courseService;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //vo context se site promenlivi sto ke se koristat
//        WebContext context = new WebContext(req, resp, req.getServletContext());
//
//        context.setVariable("enroll", this.studentService.listAll());
//
//        this.springTemplateEngine.process("studentsInCourse.html",
//                context, resp.getWriter());
        WebContext context = new WebContext(req,resp,req.getServletContext());
        Long courseId = null;
        try {
            courseId = Long.parseLong(req.getSession().getAttribute("courseId").toString());
        } catch (Exception e) {
            resp.sendRedirect("/listCourses");
            return;
        }
        Course course = courseService.findById(courseId);
        List<Student> students = courseService.listStudentsByCourse(courseId);
        context.setVariable("courseName", course.getName());
        context.setVariable("students", students);
        this.springTemplateEngine.process("studentsInCourse.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String categoryName = req.getParameter("name");
//        String categoryDesc = req.getParameter("desc");
//
//        courseService.create(categoryName, categoryDesc);
//
//        //go redirektirame korisnikot na pocetnata strana kade se site
//        resp.sendRedirect("/servlet/thymeleaf/category");
        super.doPost(req, resp);
    }
}
