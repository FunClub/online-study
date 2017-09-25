package com.taomei.service;

import com.taomei.dao.docment.Admin;
import com.taomei.dao.docment.User;
import com.taomei.dao.repository.AdminRepository;
import com.taomei.dao.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class LoginService {
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final MongoOperations mongoOperations;
    @Autowired
    public LoginService(UserRepository userRepository, AdminRepository adminRepository, MongoOperations mongoOperations) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
        this.mongoOperations = mongoOperations;
    }

    public User login(User user){
        if(user.getAdmin()){
            Query query = Query.query(where("account").is(user.getAccount()).and("password").is(user.getPassword()));
            Admin admin=mongoOperations.findOne(query,Admin.class,"admin");
            BeanUtils.copyProperties(admin,user);
        }else{
            user = userRepository.findOne(Example.of(user));
        }
        return user;
    }
}
