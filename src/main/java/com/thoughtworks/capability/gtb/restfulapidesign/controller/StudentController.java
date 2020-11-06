package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Student> addStudent(@RequestBody Student student){
        return studentService.addNewStudent(student);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Student> deleteStudent(@PathVariable int id){
        return studentService.deleteStudentById(id);
    }

    @GetMapping("/students")
    public List<Student> searchStudent(@RequestParam(required = false) String gender){
        return studentService.searchStudentList(gender);
    }

    @GetMapping("/students/{id}")
    public List<Student> searchAStudentById(@PathVariable int id){
        return studentService.searchAStudentListById(id);
    }

    @PutMapping("/students/{id}")
    public List<Student> updateStudentInformationById(@PathVariable int id,
                                                      @RequestBody Student student){
        return studentService.updateStudentListById(id,student);
    }

}
