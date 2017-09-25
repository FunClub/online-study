package com.taomei.service;

import com.taomei.dao.docment.User;
import com.taomei.dao.repository.UserRepository;
import com.taomei.dao.dto.base.studentmanagement.StudentQueryDto;
import com.taomei.dao.dto.base.studentmanagement.StudentsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class StudentManagementService {
    private final UserRepository userRepository;
    @Autowired
    public StudentManagementService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public boolean updateStudent(User user){
       userRepository.save(user);
       return true;
    }
    public StudentsDto selectStudents(StudentQueryDto dto){
        Boolean showUnAudit = dto.getShowUnAudit();
        Boolean showPage= dto.getShowPage();
        StudentsDto studentsDto = new StudentsDto();
        Pageable pageable = new PageRequest(dto.getIndex(),dto.getSize());
        User user = new User();
        Page<User> page;
        if(showPage){
            if(showUnAudit){
                page = userRepository.findAll(pageable);
            }else{
                user.setState(false);
                page = userRepository.findAll(Example.of(user),pageable);
            }
            studentsDto.setTotalElements(page.getTotalElements());
            studentsDto.setContent(page.getContent());
        }else {
            if(showUnAudit){
                user.setState(false);
                studentsDto.setContent(userRepository.findAll(Example.of(user)));
            }else{
                studentsDto.setContent( userRepository.findAll());
            }
        }

        studentsDto.setUnAuditCount(userRepository.count(Example.of(user)));
        return studentsDto;
    }
}
