package com.example.demo_manytomany.Controller;

import com.example.demo_manytomany.Entity.Courses;
import com.example.demo_manytomany.Entity.Student;
import com.example.demo_manytomany.Model.CoursesModel;
import com.example.demo_manytomany.Model.StudentModel;
import com.example.demo_manytomany.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class StudentController {
    @Autowired
    public StudentService studentService;

    @RequestMapping("/")
    public String start(){
        return "start";
    }
    @GetMapping("/addStudent")
    public String addstudent(Model model) {
        StudentModel  studentModel=new StudentModel();
        model.addAttribute("student",studentModel);
        return "addStudent";
    }
    @RequestMapping("/saveStudent")
    public String saveStudent(StudentModel studentModel,String name,int marks){
        studentModel=new StudentModel(name,marks);
        studentService.saveStudent(studentModel);
        return "start";
    }
    @RequestMapping("/viewStudents")
    public String viewStudents(Model model){
        ArrayList<StudentModel> studentModelList=studentService.getStudentList();
        System.out.println(studentModelList);
        model.addAttribute("studentModelList",studentModelList);
        return "viewAllStudents";
    }
    @RequestMapping("/addCourses")
    public String addcourses(Model model){
        CoursesModel coursesModel=new CoursesModel();
        model.addAttribute("coursesModel",coursesModel);
        return "addCourses";
    }
    @RequestMapping("/saveCourse")
    public String savecurse(CoursesModel coursesModel,String cname,String date){
        coursesModel=new CoursesModel(cname,date);
        studentService.saveCourses(coursesModel);
        return "start";
    }
    @RequestMapping("/viewCourses")
    public String viewcourses(Model model){
        ArrayList<CoursesModel> coursesModelList=studentService.getCoursesList();
        System.out.println(coursesModelList);
        model.addAttribute("coursesModelList",coursesModelList);
        return "viewAllCourses";
    }
    @RequestMapping("/viewStudentdetails")
    public String viewSpecificStudentDetails(int id,Model model){
        StudentModel studentModel=studentService.getStudentById(id);
        List<CoursesModel> allcoursesList= studentService.getCoursesList();
        model.addAttribute("studentModel",studentModel);
        model.addAttribute("allcoursesList",allcoursesList);
        return "viewspecstudent";
    }

    //student adding course
    @RequestMapping("/studentaddCourses")
    public String addSpecificstudentDetails(int id,Model model){
        StudentModel studentModel=studentService.getStudentById(id);
        List<CoursesModel> allcoursesList= studentService.getCoursesList();
        model.addAttribute("studentModel",studentModel);
        model.addAttribute("allCoursesList",allcoursesList);
        return "addcourse";
    }
    @RequestMapping("/addCoursesByStudent")
    public String addCoursesByStudent(int id,int cid,Model model){
        studentService.addCourses(id,cid);

        StudentModel studentModel=studentService.getStudentById(id);
        List<CoursesModel> allCoursesList= studentService.getCoursesList();
        model.addAttribute("studentModel",studentModel);
        model.addAttribute("allCoursesList",allCoursesList);
        return "viewspecstudent";
    }
    @RequestMapping("/viewCoursesDetails")
    public String viewSpecificCourseDetails(Integer cid,Model model){
        CoursesModel coursesModel=studentService.getCoursesById(cid);
        List<StudentModel> allStudentList= studentService.getStudentList();
        model.addAttribute("coursesModel",coursesModel);
        model.addAttribute("allStudentList",allStudentList);
        return "viewSpecCourse";
    }
    @RequestMapping("/removeCourseByStudent")
    public String removeProductByCustomer(int cid,int id,Model model){
        studentService.removeCourses(cid,id);

        StudentModel studentModel=studentService.getStudentById(id);
        List<CoursesModel> allCoursesList= studentService.getCoursesList();
        model.addAttribute("studentModel",studentModel);
        model.addAttribute("allCoursesList",allCoursesList);
        return "viewspecstudent";
    }
    @RequestMapping("/deleteCourse")
    public String deleteCourse(int cid,Model model){
        studentService.deleteCourse(cid);

        ArrayList<CoursesModel> coursesModelList=studentService.getCoursesList();
        System.out.println(coursesModelList);
        model.addAttribute("coursesModelList",coursesModelList);
        return "viewAllCourses";
    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(int id,Model model){
        studentService.deleteStudent(id);
        ArrayList<StudentModel> studentModelList=studentService.getStudentList();
        System.out.println(studentModelList);
        model.addAttribute("studentModelList",studentModelList);
        return "viewAllStudents";
    }
    @GetMapping("/updateStudent")
    public String updateStudent(@RequestParam("id") int id, Model model){
        StudentModel studentModel = studentService.getStudentById(id);
        model.addAttribute("studentModel", studentModel);
        return "UpdateStudent";
    }

    @PostMapping("/saveUpdatedStudent")
    public String saveUpdatedStudent(@ModelAttribute("studentModel") StudentModel studentModel, Model model){
        studentService.updateStudent(studentModel);
        return "redirect:/viewAllStudents";
    }

    @GetMapping("/updateCourse")
    public String updateCourse(@RequestParam("cid") int Cid, Model model){
        CoursesModel coursesModel = studentService.getCoursesById(Cid);
        model.addAttribute("coursesModel", coursesModel);
        return "UpdateCourse";
    }

    @PostMapping("/saveUpdatedCourse")
    public String saveUpdatedCourse(@ModelAttribute("coursesModel") CoursesModel coursesModel, Model model){
        studentService.updateCourse(coursesModel);
        return "redirect:/viewCourses";
    }



}
