package com.taomei.dao.repository;

import com.taomei.dao.docment.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
