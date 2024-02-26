<%@ page import="com.example.demo_manytomany.Model.StudentModel" %>
<%@ page import="com.example.demo_manytomany.Model.CoursesModel" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo_manytomany.Entity.Student" %>
<%@ page import="com.example.demo_manytomany.Entity.Courses" %>
<%@page language="java" %>
<html>
<head>
    <title>Courses Details</title>

</head>
<body>
<%
    CoursesModel coursesModel=(CoursesModel) request.getAttribute("coursesModel");
%>
<div>
    <% if(coursesModel!=null ) { %>
    <p> ID        :  <%= coursesModel.getCid() %></p>
    <p> Name      :  <%= coursesModel.getCname() %></p>
    <p> Date      :  <%= coursesModel.getDate() %></p>
    <table>
        <tr>
            <th>Student Id</th>
            <th>Student Name</th>
            <th>Student Marks </th>
        </tr>
        <%
            if(!coursesModel.getStudentList().isEmpty()) {
            for(Student student: coursesModel.getStudentList()) {
        %>
        <tr>
            <td> <%= student.getId() %> </td>
            <td> <%= student.getName() %> </td>
            <td> <%= student.getMarks() %> </td>
        </tr>
        <% }
        }
        %>
    </table>
    <% } %>
</div>
<form action="/viewCourses">
    <input type="submit" value="Back">
</form>
</body>
</html>