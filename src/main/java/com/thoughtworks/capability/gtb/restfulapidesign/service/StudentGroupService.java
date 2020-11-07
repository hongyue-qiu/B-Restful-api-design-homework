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
        int redundantTemp = redundant;
        Collections.shuffle(studentList);

        for (int i = 0; i < 6; i++) {
            StudentGroup studentGroup = new StudentGroup();
            studentGroup.setId(i+1);
            //0-4 5-9
            //i*studentNum   i*studentNum+studentNum
            int begin = i*studentNum;
            int end = i*studentNum+studentNum;
            if(redundantTemp > 0){
                end=end+studentNum+i;
                begin = begin+i;
                redundantTemp--;
            }
            if (redundantTemp == 0 && begin != 0 && redundant != 0){
                begin = i*studentNum+redundant-1;
                end = begin+studentNum;
            }

            List<Student> studentList1 = studentList.subList(begin,end);
            studentGroup.setStudentGroupsList(studentList1);
            studentGroupLists.add(studentGroup);
        }

        return studentGroupLists;
    }


}
