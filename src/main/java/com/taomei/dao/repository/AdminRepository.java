package com.taomei.dao.repository;

import com.taomei.dao.docment.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin,String>{
}
