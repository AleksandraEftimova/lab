package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.service.StudentService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="CreateStudentServlet", urlPatterns = "/createStudent")
public class CreateStudentServlet  extends HttpServlet {

    //zavisnosti
    private final SpringTemplateEngine springTemplateEngine;
    private final StudentService studentService;

    public CreateStudentServlet(SpringTemplateEngine springTemplateEngine, StudentService studentService) {
        this.springTemplateEngine = springTemplateEngine;
        this.studentService = studentService;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //vo context se site promenlivi sto ke se koristat
        WebContext context = new WebContext(req, resp, req.getServletContext());

        context.setVariable("newStudent", this.studentService.save(req.getQueryString(), req.getQueryString(), req.getQueryString(), req.getQueryString()));

        this.springTemplateEngine.process("newStudent.html",
                context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("name");
        String categoryDesc = req.getParameter("desc");

//        studentService.create(categoryName, categoryDesc);

        //go redirektirame korisnikot na pocetnata strana kade se site
        resp.sendRedirect("/servlet/thymeleaf/category");
    }
}
