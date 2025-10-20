package com.felipe.api.shoppingapi.shoppingapi.repository;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingRepository extends MongoRepository <Shopping, String>{
    List<Shop> queryByUserIdentifierLike(String userIdentifier);
    List<Shop> queryByDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Shop> findByItems_ProductIdentifier(String productIdentifier);
    List<Shop> findByDateBetweenAndTotalGreaterThanEqual(
        LocalDateTime startDate, 
        LocalDateTime endDate, 
        Integer minValue
    );
}
