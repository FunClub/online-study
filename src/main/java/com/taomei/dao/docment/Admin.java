package com.taomei.dao.docment;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admin")
public class Admin extends User{
}
