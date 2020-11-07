package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.StudentGroup;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentGroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {
    private final StudentGroupService studentGroupService;

    public GroupController(StudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }

    @GetMapping("/groups")
    public List<StudentGroup> randomGroupOfStudents(){
        return studentGroupService.randomGroupingOfStudents();
    }
}
