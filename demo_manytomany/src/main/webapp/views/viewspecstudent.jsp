<%@ page import="com.example.demo_manytomany.Model.StudentModel" %>
<%@ page import="com.example.demo_manytomany.Model.CoursesModel" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo_manytomany.Entity.Courses" %>
<%@page language="java" %>
<html>
<head>
    <title>Student Details</title>
</head>
<body>
<%
    StudentModel studentModel=(StudentModel) request.getAttribute("studentModel");
%>
<div>
    <% if(studentModel!=null ) { %>
    <p> ID        :  <%= studentModel.getId() %></p>
    <p> Name      :  <%= studentModel.getName() %></p>
    <p> Marks      :  <%= studentModel.getMarks() %></p>
    <table>
        <%
            if(!studentModel.getCoursesList().isEmpty()) { %>
        <tr>
            <th>Course Id</th>
            <th>Course Name</th>
            <th>Date</th>
        </tr>
        <%
                for(Courses courses : studentModel.getCoursesList()) {
        %>
        <tr>
            <td> <%= courses.getCid() %> </td>
            <td> <%= courses.getCname() %> </td>
            <td> <%= courses.getDate() %> </td>
        </tr>
        <% }
        }
        %>
    </table>
    <% } %>
</div>
<form action="/viewStudents">
    <input type="submit" value="Back">
</form>
</body>
</html>