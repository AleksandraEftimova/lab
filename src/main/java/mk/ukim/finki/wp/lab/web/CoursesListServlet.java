package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Test", urlPatterns = "/hello")
public class CoursesListServlet extends HttpServlet {

    //zavisnost do service
    private final StudentService studentService;
    public CoursesListServlet(StudentService studentService) {
        this.studentService = studentService;
    }

    //ne e potreben
//    public void addStudent(String newUsername, String newPass, String newName, String newSurname) {
//        if (newUsername != null && newPass != null && newName != null && newSurname != null) {
//            this.students.add(new Student(newUsername, newPass, newName, newSurname));
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("<html>");
        writer.write("<body>");
        writer.write("<h1>Did it work??</h1>");
        writer.write("<ul>");
        this.studentService.listAll().forEach(r->
                writer.format("<li>Name and Surname: %s %s </li>", r.getName(), r.getSurname()));
        writer.write("</ul>");

        writer.println("<h3>Add Category Form</h3>");
        //za posigurno prakjanje podatoci koristime post\n" +
        writer.println("<form method='POST' action='/hello'>");
        writer.println("<label for='username'>Username:</label>");
        writer.println("<input id='username' type='text' name='username'/>");
        writer.println("<label for='pass'>Password:</label>");
        writer.println("<input id='pass' type='text' name='pass'/>");
        writer.println("<label for='name'>Name:</label>");
        writer.println("<input id='name' type='text' name='name'/>");
        writer.println("<label for='surname'>Surname:</label>");
        writer.println("<input id='surname' type='text' name='surname'/>");
        writer.println("<input type='submit' value='Submit'/>");
        writer.println("</form>");
        writer.write("</body>");
        writer.write("</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //prevzemame parametar
        String studentUsername = req.getParameter("username");
        String studentPass = req.getParameter("pass");
        String studentName = req.getParameter("name");
        String studentSurname = req.getParameter("surname");
        //se dodava
        studentService.save(studentUsername, studentPass, studentName, studentSurname);
        //redirecting
        resp.sendRedirect("/hello");
    }
}
