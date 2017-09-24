package com.taomei.service;

import com.taomei.dao.docment.User;
import com.taomei.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private final UserRepository userRepository;

    @Autowired
    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(User user){
        user.setAdmin(false);
        user.setState(false);
        userRepository.insert(user);
        return true;
    }
}
