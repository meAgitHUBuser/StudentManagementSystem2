<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Management System</title>
</head>
<body>
    <h1>Student List</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Email</th>
            <th>Address</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>${student.email}</td>
                <td>${student.address}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/student/edit?id=${student.id}">Edit</a>
                    <a href="${pageContext.request.contextPath}/student/delete?id=${student.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <h2>Add New Student</h2>
    <form action="${pageContext.request.contextPath}/student/add" method="post">
        Name: <input type="text" name="name"><br>
        Age: <input type="number" name="age"><br>
        Email: <input type="email" name="email"><br>
        Address: <input type="text" name="address"><br>
        <input type="submit" value="Add Student">
    </form>
</body>
</html>
