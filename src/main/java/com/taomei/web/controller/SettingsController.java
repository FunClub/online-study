package com.taomei.web.controller;

import com.taomei.dao.docment.Menu;
import com.taomei.dao.dto.settings.InsertMenuDto;
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

    @GetMapping("/menu-item")
    public Object selectMenuItem(){
        return settingsService.selectMenu(null);
    }
}
