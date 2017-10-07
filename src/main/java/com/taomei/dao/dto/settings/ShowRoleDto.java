package com.taomei.dao.dto.settings;

import com.taomei.dao.docment.Menu;
import com.taomei.dao.docment.Role;

import java.util.List;

public class ShowRoleDto extends Role {
    private List<Menu> menus;

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
