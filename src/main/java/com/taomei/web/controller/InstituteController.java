package com.taomei.web.controller;

import com.taomei.dao.docment.Batch;
import com.taomei.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("institute")
public class InstituteController {
    private final BatchService batchService;

    @Autowired
    public InstituteController(BatchService batchService) {
        this.batchService = batchService;
    }

    @PostMapping("")
    public Object insertInstitute(@RequestBody Batch batch){
        return batchService.insertInstitute(batch);
    }
    @GetMapping("")
    public Object selectInstitute(){
        return batchService.selectInstitute();
    }
}
