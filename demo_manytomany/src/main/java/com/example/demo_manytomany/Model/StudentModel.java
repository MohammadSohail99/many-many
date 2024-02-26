package com.example.demo_manytomany.Model;

import com.example.demo_manytomany.Entity.Courses;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@ToString

public class StudentModel {
    private int id;
    private String name;
    private int marks;
    List<CoursesModel> coursesModelList=new ArrayList<>();
    List<Courses>coursesList=new ArrayList<>();

    public List<Courses> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<Courses> coursesList) {
        this.coursesList = coursesList;
    }

    public StudentModel(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public StudentModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public List<CoursesModel> getCoursesModelList() {
        return coursesModelList;
    }

    public void setCoursesModelList(List<CoursesModel> coursesModelList) {
        this.coursesModelList = coursesModelList;
    }
}
