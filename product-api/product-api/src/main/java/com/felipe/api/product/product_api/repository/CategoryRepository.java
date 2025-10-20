package com.felipe.api.product.product_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.felipe.api.product.product_api.model.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

}
