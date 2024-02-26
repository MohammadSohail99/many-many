package com.example.demo_manytomany.Model;

import com.example.demo_manytomany.Entity.Student;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@ToString
public class CoursesModel {
    private int cid;
    private String cname;
    private String date;
    List<StudentModel> studentModelList=new ArrayList<>();
    List<Student>studentList=new ArrayList<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public CoursesModel(String cname, String date) {
        this.cname=cname;
        this.date=date;
    }

    public CoursesModel() {

    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StudentModel> getStudentModelList() {
        return studentModelList;
    }

    public void setStudentModelList(List<StudentModel> studentModelList) {
        this.studentModelList = studentModelList;
    }
}
