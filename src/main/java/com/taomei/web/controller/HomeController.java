package com.taomei.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("home")
public class HomeController {
    @GetMapping("/can-to")
    public Object canToHome(HttpSession httpSession){
        return httpSession.getAttribute("user");
    }
}
