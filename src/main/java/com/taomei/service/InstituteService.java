package com.taomei.service;

import com.taomei.dao.docment.Institute;
import com.taomei.dao.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstituteService {
    private final InstituteRepository instituteRepository;

    @Autowired
    public InstituteService(InstituteRepository instituteRepository) {
        this.instituteRepository = instituteRepository;
    }

    public  boolean insertInstitute(Institute institute){
        instituteRepository.insert(institute);
        return true;
    }

    public List<Institute> selectInstitute(){
        return instituteRepository.findAll();
    }
}
