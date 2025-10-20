package com.felipe.api.product.product_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.felipe.api.product.product_api.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
     List<Product> findByCategory_Id(String categoriaId);
     Optional<Product> findByProductIdentifier(String productIdentifier);
}
