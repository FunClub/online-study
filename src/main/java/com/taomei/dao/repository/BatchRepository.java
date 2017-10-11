package com.taomei.dao.repository;

import com.taomei.dao.docment.Batch;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BatchRepository extends MongoRepository<Batch,String>{
}
