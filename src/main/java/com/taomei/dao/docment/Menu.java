package com.taomei.dao.docment;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "menu")
public class Menu extends MenuItem{
    private List<String> itemIds;

    public List<String> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<String> itemIds) {
        this.itemIds = itemIds;
    }
}
