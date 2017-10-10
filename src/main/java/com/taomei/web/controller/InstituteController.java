package com.taomei.web.controller;

import com.taomei.dao.docment.Institute;
import com.taomei.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("institute")
public class InstituteController {
    private final InstituteService instituteService;

    @Autowired
    public InstituteController(InstituteService instituteService) {
        this.instituteService = instituteService;
    }

    @PostMapping("")
    public Object insertInstitute(@RequestBody Institute institute){
        return instituteService.insertInstitute(institute);
    }
    @GetMapping("")
    public Object selectInstitute(){
        return instituteService.selectInstitute();
    }
}
