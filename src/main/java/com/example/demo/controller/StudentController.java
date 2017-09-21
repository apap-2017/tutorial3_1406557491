package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.InMemoryStudentService;
import com.example.demo.service.StudentService;
import com.example.demo.model.StudentModel;

import java.util.List;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController() {
        studentService = new InMemoryStudentService();
    }

    @RequestMapping("/student/add")
    public String add(@RequestParam(value="name", required=true)String name,
                      @RequestParam(value="npm", required=true)String npm,
                      @RequestParam(value="gpa", required=true)double gpa) {
        StudentModel student = new StudentModel(name, npm, gpa);
        studentService.addStudent(student);
        return "add";
    }

    @RequestMapping("/student/view")
    public String view(Model model, @RequestParam(value="npm", required=true)String npm) {
        StudentModel student = studentService.selectStudent(npm);
        model.addAttribute("student", student);
        return "view";
    }

    @RequestMapping("/student/viewall")
    public String viewAll(Model model) {
        List<StudentModel> students = studentService.selectAllStudents();
        model.addAttribute("students", students);
        return "viewall";
    }

    @RequestMapping("/student/view/{npm}")
    public String viewNpm(@PathVariable String npm, Model model) {
        StudentModel student = studentService.selectStudent(npm);
        model.addAttribute("student", student);
        return "view";
    }

    @RequestMapping("student/delete/{npm}")
    public String delete(@PathVariable String npm, Model model) {
        boolean tmp = studentService.delete(npm);
        model.addAttribute("deleted", tmp);
        return "delete";
    }
}