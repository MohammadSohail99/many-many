<%@ page import="com.example.demo_manytomany.Model.CoursesModel" %>
<%@page language="java" %>
<html>
<head>
    <title>Courses Details</title>
    <% CoursesModel coursesModel=(CoursesModel) request.getAttribute("coursesModel"); %>
</head>
<body>
<h1>Enter Courses Details</h1>
<form action="saveCourse" method="post" >
    <input type="hidden" value="<%=coursesModel%>" id="coursesModel" name="coursesModel">
    <label for="cname"> Enter Course Name  </label>
    <input type="text" id="cname" name="cname" required>
    <br>
    <label for="date">Enter date  </label>
    <input type="text" id="date" name="date" required>
    <br>
    <input type="submit" value="Add Course">
</form>
<form action="/">
    <input type="submit" value="Home">
</form>
</body>
</html>