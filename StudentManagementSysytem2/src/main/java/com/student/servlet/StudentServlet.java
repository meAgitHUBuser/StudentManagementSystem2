package main.java.com.student.servlet;


import main.java.com.student.dao.StudentDAO;
import main.java.com.student.dao.StudentDAOImpl;
import main.java.com.student.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student/*")
public class StudentServlet extends HttpServlet {
    private StudentDAO studentDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        studentDAO = new StudentDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            List<Student> students = studentDAO.getAllStudents();
            request.setAttribute("students", students);
            request.getRequestDispatcher("/WEB-INF/student.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        switch (action) {
            case "/add":
                addStudent(request, response);
                break;
            case "/edit":
                editStudent(request, response);
                break;
            case "/delete":
                deleteStudent(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/student/");
                break;
        }
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Student student = new Student(name, age, email, address);
        studentDAO.addStudent(student);

        response.sendRedirect(request.getContextPath() + "/student/");
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Student student = new Student(name, age, email, address);
        student.setId(id);
        studentDAO.updateStudent(student);

        response.sendRedirect(request.getContextPath() + "/student/");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDAO.deleteStudent(id);

        response.sendRedirect(request.getContextPath() + "/student/");
    }
}

