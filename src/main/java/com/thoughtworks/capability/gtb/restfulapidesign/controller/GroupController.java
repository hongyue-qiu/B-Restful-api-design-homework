package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.StudentGroup;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {
    private final StudentGroupService studentGroupService;

    public GroupController(StudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }

    @GetMapping("/groups")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentGroup> randomGroupOfStudents(){
        return studentGroupService.randomGroupingOfStudents();
    }

    @PatchMapping("/groups/{id}")
    public List<StudentGroup> updateGroupName(@PathVariable int id, @RequestBody StudentGroup group){
        return studentGroupService.updateGroupName(id,group);
    }

}
