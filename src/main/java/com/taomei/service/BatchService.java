package com.taomei.service;

import com.taomei.dao.docment.Batch;
import com.taomei.dao.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchService {
    private final BatchRepository batchRepository;

    @Autowired
    public BatchService(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    public  boolean insertInstitute(Batch batch){
        batchRepository.insert(batch);
        return true;
    }

    public List<Batch> selectInstitute(){
        return batchRepository.findAll();
    }
}
