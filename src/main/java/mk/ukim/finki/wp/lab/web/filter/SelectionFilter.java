//package mk.ukim.finki.wp.lab.web.filter;
//
//import mk.ukim.finki.wp.lab.model.Course;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//@WebFilter(filterName = "SelectionFilter", urlPatterns = "/addStudent")
//public class SelectionFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig config) throws ServletException {
//        Filter.super.init(config);
//    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) resp;
//
//        String courseId = (String) request.getSession().getAttribute("courseId");
//
////        if (courseId == null || courseId.isEmpty()) {
////            response.sendRedirect("/listCourses");
////        } else {
////            chain.doFilter(req, resp);
////        }
//
////        String courseId = request.getParameter("courseId");
//
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}