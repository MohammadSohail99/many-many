<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.demo_manytomany.Model.StudentModel" %>
<%@page language="java" %>
<html>
<head>
    <title>All Students</title>
</head>
<body>
<% ArrayList studentModelList=(ArrayList) request.getAttribute("studentModelList"); %>
<table>
    <tr>
        <th> Id </th>
        <th> Name </th>
        <th> Marks </th>
        <th> View Details </th>
        <th> Add Courses </th>
        <th> Delete </th>
    </tr>
    <%
        for(Object studentModel: studentModelList) {
            StudentModel c= (StudentModel) studentModel;
    %>
    <tr>
        <td> <%= c.getId() %> </td>
        <td> <%= c.getName() %> </td>
        <td> <%= c.getMarks() %> </td>
        <td> <a href="viewStudentdetails?id=<%=c.getId() %>">View Details</a> </td>
        <td> <a href="studentaddCourses?id=<%=c.getId() %>">Add Courses</a> </td>
        <td> <a href="deleteStudent?id=<%= c.getId()%> "> Delete Student</a> </td>
        <td> <a href="updateStudent?id=<%= c.getId()%> "> Update Student</a> </td>
    <% } %>
</table>
<form action="/">
    <input type="submit" value="Home">
</form>
</body>
</html>