package com.taomei.dao.repository;

import com.taomei.dao.docment.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuRepository extends MongoRepository<Menu,String> {

}
