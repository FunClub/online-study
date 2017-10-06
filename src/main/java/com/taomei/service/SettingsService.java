package com.taomei.service;

import com.taomei.dao.docment.Menu;
import com.taomei.dao.docment.MenuItem;
import com.taomei.dao.dto.settings.InsertMenuDto;
import com.taomei.dao.dto.settings.ShowMenuDto;
import com.taomei.dao.repository.MenuItemRepository;
import com.taomei.dao.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingsService {
    private final MenuRepository menuRepository;
    private final MenuItemRepository menuItemRepository;
    @Autowired
    public SettingsService(MenuRepository menuRepository, MenuItemRepository menuItemRepository) {
        this.menuRepository = menuRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public boolean insertMenu(Menu menu){
        menuRepository.insert(menu);
        return true;
    }

    public List<Menu> selectMenu(List<String> ids){
        if(ids!=null){
            return menuRepository.findAll();
        }else{
            return menuRepository.findAll();
        }
    }
}
