package com.taomei.web.controller;

import com.taomei.dao.docment.Role;
import com.taomei.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("")
    public Object insertRole(@RequestBody Role role){
        return  roleService.insertRole(role);
    }

    @GetMapping("")
    public Object selectRole(){
        return roleService.selectRole();
    }
}
