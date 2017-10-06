package com.taomei.service;

import com.taomei.dao.docment.Menu;
import com.taomei.dao.dto.settings.QueryMenuCondition;
import com.taomei.dao.dto.settings.ShowMenuDto;
import com.taomei.dao.repository.MenuRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SettingsService {
    private final MenuRepository menuRepository;

    @Autowired
    public SettingsService(MenuRepository menuRepositoryy) {
        this.menuRepository = menuRepositoryy;
    }
    public  boolean updateMenu(Menu menu){
        menuRepository.save(menu);
        return true;
    }
    public boolean insertMenu(Menu menu) {
        menuRepository.insert(menu);
        return true;
    }

    public List<ShowMenuDto> selectMenu(QueryMenuCondition condition) {
        String type = condition.getType();
        List<ShowMenuDto> showMenuDtos = new ArrayList<>();
        List<Menu> menus = null;
        if (type != null) {
            if(type.equals("all")){//查询全部/
                menus = menuRepository.findAll();
            }else{//根据类型查询
                Menu menu = new Menu();
                menu.setType(type);
                menus = menuRepository.findAll(Example.of(menu));
            }
        } else {

        }
        ShowMenuDto showMenuDto = null;
        if (menus != null) {
            for (Menu menu : menus) {
                showMenuDto = new ShowMenuDto();
                BeanUtils.copyProperties(menu, showMenuDto);
                if(menu.getType().equals("menu")&&menu.getItemIds()!=null){
                    List<Menu> items = (ArrayList<Menu>) menuRepository.findAll(menu.getItemIds());
                    showMenuDto.setItems(items);
                }
                showMenuDtos.add(showMenuDto);
            }
        }
        return showMenuDtos;
    }
}
