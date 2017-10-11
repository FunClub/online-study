package com.taomei.web.controller;

import com.taomei.dao.docment.Course;
import com.taomei.dao.dto.base.PageRequestDto;
import com.taomei.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("course/")
public class CourseController {
    private final CourseService courseService;


    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("")
    public Object insertCourse(@RequestBody Course course){
        return courseService.insertCourse(course);
    }
    @GetMapping("")
    public Object selectAllCourse(){

        return courseService.selectAllCourse();
    }
}
