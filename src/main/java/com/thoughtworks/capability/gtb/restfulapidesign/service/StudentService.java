package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> studentLists = new ArrayList<>();
    public StudentService(){
        studentLists.add(new Student(1, "yy","male","q"));
        studentLists.add(new Student(2, "aa","male","h"));
        studentLists.add(new Student(3, "ll","male","y"));
    }

    public List<Student> addNewStudent(Student student){
        studentLists.add(student);
        return studentLists;
    }

}
