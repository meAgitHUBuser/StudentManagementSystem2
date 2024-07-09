# Student Management System

This project is a simple web application for managing student records, developed using Java technologies including Servlets, JSP, and JDBC.

## Features

- View a list of students
- Add new students
- Edit existing student details
- Delete students

## Technologies Used

- Java
- Servlets
- JSP (JavaServer Pages)
- JDBC (Java Database Connectivity)
- MySQL (as the database)
- Maven (for dependency management)

## Directory Structure

StudentManagementSystem
├── src
│ ├── main
│ │ ├── java
│ │ │ └── com
│ │ │ └── student
│ │ │ ├── dao
│ │ │ │ ├── StudentDAO.java
│ │ │ │ └── StudentDAOImpl.java
│ │ │ ├── model
│ │ │ │ └── Student.java
│ │ │ ├── servlet
│ │ │ │ └── StudentServlet.java
│ │ │ ├── util
│ │ │ │ └── DBUtil.java
│ │ │ └── MainApp.java
│ │ ├── resources
│ │ │ └── db.properties
│ │ └── webapp
│ │ ├── META-INF
│ │ ├── WEB-INF
│ │ │ ├── web.xml
│ │ ├── index.jsp
│ │ └── student.jsp
├── pom.xml


## How to Run

1. **Database Setup**:
   - Install MySQL and create a database named `studentdb`.
   - Import `student.sql` script to create the `students` table.

2. **Configure Database**:
   - Update `src/main/resources/db.properties` with your MySQL username and password:

     ```
     properties
     jdbc.driver=com.mysql.jdbc.Driver
     jdbc.url=jdbc:mysql://localhost:3306/studentdb
     jdbc.username=root
     jdbc.password=password
     ```

3. **Build and Run**:
   - Build the project using Maven: `mvn clean package`
   - Deploy the generated WAR file to a servlet container like Apache Tomcat.

4. **Access the Application**:
   - Open a web browser and go to `http://localhost:8080/StudentManagementSystem/`

## Credits

This project was created using AI. Initial code generation and project structuring assistance were provided by an AI language model.
