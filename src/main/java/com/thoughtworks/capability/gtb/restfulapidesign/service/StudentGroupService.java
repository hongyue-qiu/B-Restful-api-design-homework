package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.StudentGroup;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StudentGroupService {
    private final StudentService studentService;
    private List<StudentGroup> studentGroupLists = new ArrayList<>();
    public StudentGroupService(StudentService studentService){
        this.studentService = studentService;
    }

    public List<StudentGroup> randomGroupingOfStudents(){
        List<Student> studentList = studentService.searchStudentList(null);
        int studentNum = studentList.size()/6;
        int redundant = studentList.size()%6;
        Collections.shuffle(studentList);
        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setId(1);
        studentGroup.setStudentGroupsList(studentList.subList(0,studentNum-1));
        for (int i = 0; i < 6; i++) {
            studentGroup.setId(i+1);
            //0-4 5-9
            //0*stu-stu+pre-1 1*stu-stu+pre-1
            studentGroup.setStudentGroupsList(studentList.subList(i*studentNum,i*studentNum+studentNum-1));
            studentGroupLists.add(studentGroup);
        }

        for (int i = 0; i < redundant; i++) {
            Student studentTemp = studentList.subList(6*studentNum,studentList.size()-1).get(i);
            studentGroupLists.get(i).getStudentGroupsList().add(studentTemp);
        }


        return studentGroupLists;
    }


}
