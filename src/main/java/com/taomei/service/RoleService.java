package com.taomei.service;

import com.taomei.dao.docment.Role;
import com.taomei.dao.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public boolean insert(Role role){
        roleRepository.insert(role);
        return  true;
    }
}
