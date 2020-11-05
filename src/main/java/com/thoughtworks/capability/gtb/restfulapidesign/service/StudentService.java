package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Student> deleteStudentById(int id){
        List<Student> studentListTemp = studentLists.stream()
                .filter(stu -> !stu.getId().equals(id)).collect(Collectors.toList());
        studentLists = studentListTemp;
        return studentLists;
    }

    public List<Student> searchStudentList(String gender){
        List<Student> studentList;
        if(gender!=null){
            studentList = studentLists.stream()
                    .filter(stu -> stu.getGender().equals(gender)).collect(Collectors.toList());
        }else {
            studentList = studentLists;
        }
        return studentList;
    }

    public List<Student> searchAStudentListById(int id){
        List<Student> studentListTemp = studentLists.stream()
                .filter(stu -> stu.getId().equals(id)).collect(Collectors.toList());
        return studentListTemp;
    }

}
