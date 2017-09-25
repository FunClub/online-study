package com.taomei.web.controller;

import com.taomei.dao.docment.User;
import com.taomei.dao.dto.base.studentmanagement.StudentQueryDto;
import com.taomei.service.StudentManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student-management")
public class StudentManagementController {

    private final StudentManagementService service;

    @Autowired
    public StudentManagementController(StudentManagementService service) {
        this.service = service;
    }
    @PutMapping("/student")
    public Object updateStudents(@RequestBody User user){
        return service.updateStudent(user);
    }
    @PostMapping("/students")
    public Object selectStudents(@RequestBody StudentQueryDto dto){
        return service.selectStudents(dto);
    }
}
