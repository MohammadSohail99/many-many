package com.example.demo_manytomany.Service;

import com.example.demo_manytomany.Entity.Courses;
import com.example.demo_manytomany.Entity.Student;
import com.example.demo_manytomany.Model.CoursesModel;
import com.example.demo_manytomany.Model.StudentModel;
import com.example.demo_manytomany.Repository.CoursesRepo;
import com.example.demo_manytomany.Repository.StudentRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService implements StudentServiceInterface {
    @Autowired
    public StudentRepo studentRepo;
    @Autowired
    public CoursesRepo coursesRepo;

    public void saveStudent(StudentModel studentModel) {
        Student customer=new Student();
        BeanUtils.copyProperties(studentModel,customer);
        studentRepo.save(customer);
    }

    public ArrayList<StudentModel> getStudentList() {
        List<Student> studentList=studentRepo.findAll();
        List<StudentModel> studentModelList=new ArrayList<>();
        studentList.forEach(customer -> {
            StudentModel studentModel=new StudentModel();
            BeanUtils.copyProperties(customer,studentModel);
            studentModelList.add(studentModel);
        });
        return (ArrayList<StudentModel>) studentModelList;
    }
    public void saveCourses(CoursesModel coursesModel) {
        Courses courses=new Courses();
        BeanUtils.copyProperties(coursesModel,courses);
        coursesRepo.save(courses);
    }
    public ArrayList<CoursesModel> getCoursesList() {
        List<Courses> coursesList=coursesRepo.findAll();
        List<CoursesModel> coursesModelList=new ArrayList<>();
        coursesList.forEach(course -> {
            CoursesModel coursesModel=new CoursesModel();
            BeanUtils.copyProperties(course,coursesModel);
            coursesModelList.add(coursesModel);
        });
        System.out.println(coursesModelList);
        return (ArrayList<CoursesModel>) coursesModelList;
    }
    public StudentModel getStudentById(int id) {
        Student student=studentRepo.getReferenceById(id);
        StudentModel studentModel=new StudentModel();
        BeanUtils.copyProperties(student,studentModel);
        return studentModel;
    }
    public CoursesModel getCoursesById(int cid) {
        Courses courses=coursesRepo.getReferenceById(cid);
        CoursesModel coursesModel=new CoursesModel();
        BeanUtils.copyProperties(courses,coursesModel);
        return coursesModel;
    }
    public void addCourses(int id, int cid) {
        Student student=studentRepo.getReferenceById(id);
        Courses courses=coursesRepo.getReferenceById(cid);

        List<Courses> coursesList = student.getCoursesList();
        List<Student> studentList=courses.getStudentList();

        coursesList.add(courses);
        studentList.add(student);

        student.setCoursesList(coursesList);
        courses.setStudentList(studentList);

        studentRepo.save(student);
        coursesRepo.save(courses);
    }
    public void removeCourses(int cid, int id) {
        Student student=studentRepo.getReferenceById(id);
        Courses courses=coursesRepo.getReferenceById(cid);

        List<Courses> coursesList = student.getCoursesList();
        List<Student> studentList=courses.getStudentList();

        coursesList.remove(courses);
        studentList.remove(student);

        student.setCoursesList(coursesList);
        courses.setStudentList(studentList);

        studentRepo.save(student);
        coursesRepo.save(courses);
    }
    public void deleteCourse(int cid) {
        Courses courses=coursesRepo.getReferenceById(cid);
        List<Student> studentList=courses.getStudentList();

        for(Student student: studentList){
            List<Courses> coursesList=student.getCoursesList();
            if(coursesList.contains(courses)){
                coursesList.remove(courses);
                student.setCoursesList(coursesList);
                studentRepo.save(student);
            }
        }

        courses.setStudentList(new ArrayList<>());
        coursesRepo.delete(courses);
    }

    public void deleteStudent(int id) {
        Student student=studentRepo.getReferenceById(id);
        List<Courses> coursesList=student.getCoursesList();

        for(Courses courses: coursesList){
            List<Student> studentList=courses.getStudentList();
            if(studentList.contains(student)){
                studentList.remove(student);
                courses.setStudentList(studentList);
                coursesRepo.save(courses);
            }
        }
        student.setCoursesList(new ArrayList<>());
        studentRepo.delete(student);
    }
    public String updateStudent(StudentModel studentModel) {
        Optional<Student> studentOptional = studentRepo.findById(studentModel.getId());
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            BeanUtils.copyProperties(studentModel, student);
            studentRepo.save(student);
            return "Student updated successfully";
        }
        return "Student not found";
    }
    public String updateCourse(CoursesModel coursesModel) {
        Optional<Courses> courseOptional = coursesRepo.findById(coursesModel.getCid());
        if (courseOptional.isPresent()) {
            Courses course = courseOptional.get();
            BeanUtils.copyProperties(coursesModel, course);
            coursesRepo.save(course);
            return "Course updated successfully";
        }
        return "Course not found";
    }

}
