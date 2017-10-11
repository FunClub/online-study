package com.taomei.service;

import com.taomei.dao.docment.Batch;
import com.taomei.dao.docment.Course;
import com.taomei.dao.dto.coursemanagement.ShowCourseDto;
import com.taomei.dao.repository.BatchRepository;
import com.taomei.dao.repository.CourseRepository;
import com.taomei.util.TimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    private final BatchRepository batchRepository;
    @Autowired
    public CourseService(CourseRepository courseRepository, BatchRepository batchRepository) {
        this.courseRepository = courseRepository;
        this.batchRepository = batchRepository;
    }

    public boolean insertCourse(Course course){
        course.setDate(TimeUtil.getSimpleTime());
        courseRepository.insert(course);
        return true;
    }
    public List<ShowCourseDto> selectAllCourse(){
        List<Course> courses = courseRepository.findAll(new Sort(Sort.Direction.DESC,"date"));
        List<ShowCourseDto> showCourseDtos = new ArrayList<>();
        ShowCourseDto showCourseDto=null;
        for(Course course:courses){
            showCourseDto = new ShowCourseDto();
            BeanUtils.copyProperties(course,showCourseDto);
            Batch batch = batchRepository.findOne(course.getBatchId());
            showCourseDto.setBatch(batch.getName());
            showCourseDtos.add(showCourseDto);
        }
        return showCourseDtos;
    }
}
