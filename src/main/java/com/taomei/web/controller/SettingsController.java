package com.taomei.web.controller;

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
    public Object insertMenu(@RequestBody InsertMenuDto dto){
        return settingsService.insertMenu(dto);
    }

    @GetMapping("/menu-item")
    public Object selectMenuItem(){
        return settingsService.selectMenuItem(null);
    }
}
