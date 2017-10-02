package com.taomei.dao.dto.settings;

import com.taomei.dao.docment.Menu;
import com.taomei.dao.docment.MenuItem;

import java.util.List;

public class InsertMenuDto {
    private String type;
    private MenuItem menuItem;
    private Menu menu;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
