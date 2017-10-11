package com.taomei.service;

import com.taomei.dao.docment.Menu;
import com.taomei.dao.dto.settings.QueryMenuDto;
import com.taomei.dao.dto.settings.ShowMenuDto;
import com.taomei.dao.repository.MenuRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@CacheConfig(cacheNames="app-cache")
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
    @CacheEvict(key = "'menu'")
    public boolean insertMenu(Menu menu) {
        menuRepository.insert(menu);
        return true;
    }
    @Cacheable(key = "'menu'")
    public List<ShowMenuDto> selectMenu(QueryMenuDto condition) {
        String type = condition.getType();
        List<ShowMenuDto> showMenuDtos = new ArrayList<>();
        List<Menu> menus = null;
        if (type != null) {
            if(type.equals("all")){//查询全部/
                menus = menuRepository.findAll(new Sort(Sort.Direction.DESC,"id"));
            }else{//根据类型查询
                Menu menu = new Menu();
                menu.setType(type);
                menus = menuRepository.findAll(Example.of(menu),new Sort(Sort.Direction.DESC,"id"));
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
