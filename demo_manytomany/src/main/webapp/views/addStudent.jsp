<%@ page import="com.example.demo_manytomany.Model.StudentModel" %>
<%@page language="java" %>
<html>
<head>
    <title>Student Details</title>
    <% StudentModel studentModel=(StudentModel) request.getAttribute("studentModel"); %>
</head>
<body>
    <h1>Enter Student Details</h1>
    <form action="saveStudent" method="post" >
        <input type="hidden" value="<%=studentModel%>" id="studentModel" name="studentModel">
        <label for="name"> Enter Name:  </label>
        <input type="text" id="name" name="name" required>
        <br>
        <label for="marks">Enter Marks:  </label>
        <input type="text" id="marks" name="marks" required>
        <br>
        <input type="submit" value="Add Student">
    </form>
    <form action="/">
        <input type="submit" value="Home">
    </form>
</body>
</html>