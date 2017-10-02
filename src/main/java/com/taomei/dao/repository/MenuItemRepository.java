package com.taomei.dao.repository;

import com.taomei.dao.docment.MenuItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuItemRepository extends MongoRepository<MenuItem,String> {
}
