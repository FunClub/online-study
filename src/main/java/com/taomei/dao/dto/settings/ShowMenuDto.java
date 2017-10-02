package com.taomei.dao.dto.settings;

import com.taomei.dao.docment.MenuItem;

import java.util.List;

public class ShowMenuDto extends MenuItem {
    private List<MenuItem> items;

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }
}
