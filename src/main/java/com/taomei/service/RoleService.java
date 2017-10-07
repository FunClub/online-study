package com.taomei.service;

import com.taomei.dao.docment.Menu;
import com.taomei.dao.docment.Role;
import com.taomei.dao.dto.settings.ShowRoleDto;
import com.taomei.dao.repository.MenuRepository;
import com.taomei.dao.repository.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final MenuRepository menuRepository;
    @Autowired
    public RoleService(RoleRepository roleRepository, MenuRepository menuRepository) {
        this.roleRepository = roleRepository;
        this.menuRepository = menuRepository;
    }

    public boolean insertRole(Role role){
        roleRepository.insert(role);
        return  true;
    }

    public List<ShowRoleDto> selectRole(){
        List<Role> roles = roleRepository.findAll();
        ShowRoleDto showRoleDto = null;
        List<ShowRoleDto> showRoleDtos = new ArrayList<>();
        for (Role role:roles){
            showRoleDto = new ShowRoleDto();
            BeanUtils.copyProperties(role,showRoleDto);
            List<String> menuIds = role.getMenuIds();
            List<Menu> menus = (List<Menu>) menuRepository.findAll(menuIds);
            showRoleDto.setMenus(menus);
            showRoleDtos.add(showRoleDto);
        }

        return showRoleDtos;
    }
}
