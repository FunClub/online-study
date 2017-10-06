package com.taomei.dao.dto.settings;

import com.taomei.dao.docment.Menu;

public class InsertMenuDto {
    private String type;
    private Menu menu;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
