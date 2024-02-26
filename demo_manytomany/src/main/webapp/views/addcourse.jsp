<%@ page import="com.example.demo_manytomany.Model.StudentModel" %>
<%@ page import="com.example.demo_manytomany.Entity.Courses" %>
<%@ page import="com.example.demo_manytomany.Model.CoursesModel" %>
<%@ page import="java.util.List" %>
<%@page language="java" %>
<html>
<head>
</head>
<body>
<%
    StudentModel studentModel=(StudentModel) request.getAttribute("studentModel");
    List<CoursesModel> allCoursesList=(List<CoursesModel>) request.getAttribute("allCoursesList");
%>
<div>
    <% if(studentModel!=null ) { %>
    <p> ID        :  <%= studentModel.getId() %></p>
    <p> Name      :  <%= studentModel.getName() %></p>
    <p> Age       :  <%= studentModel.getMarks() %></p>
    <table>
        <tr>
            <th>Course Id</th>
            <th>Course Name</th>
            <th>Date</th>
            <th>Course Status</th>
        </tr>
        <%
            for(CoursesModel course : allCoursesList) {
                boolean isFound=false;
                for(Courses p: studentModel.getCoursesList()){
                    if(p.getCid()==course.getCid()){
                        isFound=true;
                        break;
                    }
                }
                if(!isFound) {
        %>
            <tr>
                <td> <%= course.getCid() %> </td>
                <td> <%= course.getCname() %> </td>
                <td> <%= course.getDate() %> </td>
                <td> <a href="addCoursesByStudent?cid=<%= course.getCid()%>&id=<%=studentModel.getId()%>" >Add</a> </td>
            </tr>
            <% } else { %>
            <tr>
                <td> <%= course.getCid() %> </td>
                <td> <%= course.getCname() %> </td>
                <td> <%= course.getDate() %> </td>
                <td> <a href="removeCourseByStudent?cid=<%= course.getCid()%>&id=<%=studentModel.getId()%>" >remove</a> </td>
            </tr>
            <% }
            } %>
    </table>
    <% } %>
</div>
<form action="/viewStudents">
    <input type="submit" value="Back">
</form>
</body>
</html>
