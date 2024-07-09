package main.java.com.student.dao;

import main.java.com.student.model.Student;
import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents();
    Student getStudentById(int studentId);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int studentId);
}
