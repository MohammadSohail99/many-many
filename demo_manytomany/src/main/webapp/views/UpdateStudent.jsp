<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.example.demo_manytomany.Model.StudentModel" %>
<html>
<h2>Update Student</h2>

<form:form action="saveUpdatedStudent" modelAttribute="studentModel">
    <table>
        <tr>
            <td>Student ID </td> <td> <form:input path="id" readonly="true"/> </td>
            <td><form:errors path="id"/></td>
        </tr>
        <tr>
            <td>Student Name </td> <td> <form:input path="name"/> </td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr>
             <td>Student Marks </td> <td> <form:input path="marks"/> </td>
             <td><form:errors path="marks"/></td>
        </tr>
        <tr>
            <td col span="2"> <input type="submit" value="Update Student"> </td>
        </tr>
    </table>
</form:form>
</html>
