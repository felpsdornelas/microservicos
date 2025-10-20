package com.felipe.api.shoppingapi.shoppingapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.felipe.api.shoppingapi.shoppingapi.model.Item;

public interface ItemRepository extends MongoRepository <Item, String>{
    Item findByProductIdentifier(String product_identifier);
}