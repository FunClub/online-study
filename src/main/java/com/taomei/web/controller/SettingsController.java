package com.taomei.web.controller;

import com.taomei.dao.docment.Menu;
import com.taomei.dao.dto.settings.QueryMenuDto;
import com.taomei.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("settings")
public class SettingsController {
    private final SettingsService settingsService;

    @Autowired
    public SettingsController(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    @PostMapping("/menu")
    public Object insertMenu(@RequestBody Menu menu){
        return settingsService.insertMenu(menu);
    }

    @PutMapping("/menu")
    public Object updateMenu(@RequestBody Menu menu){
        return  this.settingsService.updateMenu(menu);
    }
    @GetMapping("/menu/{type}")
    public Object selectMenuItem(@PathVariable("type") String type){
        QueryMenuDto condition = new QueryMenuDto();
        condition.setType(type);
        return settingsService.selectMenu(condition);
    }
}
