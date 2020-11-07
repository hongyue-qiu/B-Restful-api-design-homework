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
        studentLists.add(new Student(4, "zz","male","q"));
        studentLists.add(new Student(5, "aa","male","h"));
        studentLists.add(new Student(6, "qq","male","y"));
//        studentLists.add(new Student(7, "kk","male","k"));
//        studentLists.add(new Student(8, "aa","male","h"));
//        studentLists.add(new Student(9, "qq","male","y"));
//        studentLists.add(new Student(10, "kk","male","k"));
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
        List<Student> studentListTemp;
        if(gender!=null){
            studentListTemp = studentLists.stream()
                    .filter(stu -> stu.getGender().equals(gender)).collect(Collectors.toList());
        }else {
            studentListTemp = studentLists;
        }
        return studentListTemp;
    }

    public List<Student> searchAStudentListById(int id){
        List<Student> studentListTemp = studentLists.stream()
                .filter(stu -> stu.getId().equals(id)).collect(Collectors.toList());
        return studentListTemp;
    }

    public List<Student> updateStudentListById(int id,Student student){
        studentLists = studentLists.stream().map(stu ->{
            if (stu.getId().equals(id)) {
                if(!stu.getGender().equals(student.getGender())) stu.setGender(student.getGender());
                if(!stu.getName().equals(student.getName())) stu.setName(student.getName());
                if(!stu.getNote().equals(student.getNote())) stu.setNote(student.getNote());
            }
            return stu;
        }).collect(Collectors.<Student>toList());
//        System.out.println(studentLists);
        return studentLists;
    }

}
