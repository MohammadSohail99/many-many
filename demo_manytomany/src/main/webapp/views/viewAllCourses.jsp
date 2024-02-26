<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.demo_manytomany.Model.CoursesModel" %>
<%@ page language="java" %>
<html>
<head>
    <title>All Courses</title>
</head>
<body>
<%
    ArrayList coursesModelList = (ArrayList) request.getAttribute("coursesModelList");
    if (coursesModelList != null) {
%>
<table>
    <tr>
        <th> Course Id </th>
        <th> Course Name </th>
        <th> Date </th>
        <th> Number of Students </th>
        <th> View Details </th>
        <th> Delete </th>
    </tr>
    <%
        for (Object coursesModel : coursesModelList) {
            CoursesModel p = (CoursesModel) coursesModel;
    %>
    <tr>
        <td> <%= p.getCid() %> </td>
        <td> <%= p.getCname() %> </td>
        <td> <%= p.getDate() %> </td>
        <td> <%= p.getStudentList().size() %> </td>
        <td> <a href="viewCoursesDetails?cid=<%= p.getCid() %>">View Details</a> </td>
        <td> <a href="deleteCourse?cid=<%= p.getCid() %> "> Delete Course</a> </td>
        <td> <a href="updateCourse?cid=<%= p.getCid() %> "> Update Course</a> </td>
    </tr>
    <% } %>
</table>
<%
    } else {
        out.println("No products available.");
    }
%>
<form action="/">
    <input type="submit" value="Home">
</form>
</body>
</html>

