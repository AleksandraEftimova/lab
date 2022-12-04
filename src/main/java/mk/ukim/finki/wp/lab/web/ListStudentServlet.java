package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.service.CourseService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="StudentListServlet", urlPatterns = "/addStudent")
public class ListStudentServlet  extends HttpServlet {

    //zavisnosti
    private final SpringTemplateEngine springTemplateEngine;
    private final CourseService courseService;

    public ListStudentServlet(SpringTemplateEngine springTemplateEngine, CourseService courseService) {
        this.springTemplateEngine = springTemplateEngine;
        this.courseService = courseService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //vo context se site promenlivi sto ke se koristat
        WebContext context = new WebContext(req, resp, req.getServletContext());
        Long courseId = null;
        try {
            courseId = Long.parseLong(req.getSession().getAttribute("courseId").toString());
        } catch (Exception e) {
            resp.sendRedirect("/listCourses");
            return;
        }
        context.setVariable("courseId", courseId);
        context.setVariable("students", courseService.listStudentsByCourse(courseId));

        this.springTemplateEngine.process("listStudents.html", context, resp.getWriter());
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
        String username = req.getParameter("username");
        Long courseId = (Long) req.getSession().getAttribute("courseId");

        this.courseService.addStudentInCourse(username, courseId);

        resp.sendRedirect("/studentEnrollmentSummary");
    }
}
