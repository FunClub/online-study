package com.taomei.dao.repository;

import com.taomei.dao.docment.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role,String>{
}
