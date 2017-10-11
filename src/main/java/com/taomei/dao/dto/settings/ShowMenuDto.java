package com.taomei.dao.dto.settings;

import com.taomei.dao.docment.Menu;
import com.taomei.dao.docment.MenuItem;

import java.io.Serializable;
import java.util.List;

public class ShowMenuDto extends MenuItem implements Serializable{
    private List<Menu> items;

    public List<Menu> getItems() {
        return items;
    }

    public void setItems(List<Menu> items) {
        this.items = items;
    }
}
