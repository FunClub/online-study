package com.taomei.dao.repository;

import com.taomei.dao.docment.Institute;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InstituteRepository extends MongoRepository<Institute,String>{
}
