package com.taomei.dao.dto.settings;

import java.util.List;

public class QueryMenuCondition {
    private String type;
    private List<String> menuIds;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<String> menuIds) {
        this.menuIds = menuIds;
    }
}
