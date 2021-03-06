package com.example.demo.service;

import java.util.List;
import com.example.demo.model.StudentModel;

public interface StudentService {
    StudentModel selectStudent(String npm);
    List<StudentModel> selectAllStudents();
    void addStudent(StudentModel student);
    boolean delete(String npm);
}