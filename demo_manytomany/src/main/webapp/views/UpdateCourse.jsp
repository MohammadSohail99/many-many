<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.example.demo_manytomany.Model.CoursesModel" %>
<html>
<h2>Update Course</h2>

<form:form action="saveUpdatedCourse" modelAttribute="coursesModel">
    <table>
        <tr>
            <td>Course ID </td> <td> <form:input path="cid" readonly="true"/> </td>
            <td><form:errors path="cid"/></td>
        </tr>
        <tr>
            <td>Course Name </td> <td> <form:input path="cname"/> </td>
            <td><form:errors path="cname"/></td>
        </tr>
        <tr>
             <td>Course Date </td> <td> <form:input path="date"/> </td>
             <td><form:errors path="date"/></td>
        </tr>
        <tr>
            <td col span="2"> <input type="submit" value="Update Course"> </td>
        </tr>
    </table>
</form:form>
</html>
