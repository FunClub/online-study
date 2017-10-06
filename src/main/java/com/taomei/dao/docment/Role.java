package com.taomei.dao.docment;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Role {
    @Id
    private String id;
    private String name;
    private List<String> menuIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<String> menuIds) {
        this.menuIds = menuIds;
    }
}
