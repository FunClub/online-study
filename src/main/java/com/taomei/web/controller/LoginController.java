package com.taomei.web.controller;

import com.taomei.dao.docment.User;
import com.taomei.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("")
    public Object login(@RequestBody User user, HttpSession session){
        user = loginService.login(user);
        session.setAttribute("user",user);
        return user;
    }
}
