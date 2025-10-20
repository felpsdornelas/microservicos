package com.felipe.api.product.product_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.api.product.product_api.model.Product;
import com.felipe.api.product.product_api.model.dto.ProductDTO;
import com.felipe.api.product.product_api.repository.ProductRepository;
import com.felipe.api.product.product_api.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> getProducts() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable String id) {
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO saveProduct(@RequestBody @Valid ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable String id, @Valid @RequestBody ProductDTO productDTO) {
        return productService.update(id, productDTO);
    }

    @GetMapping("/pageable")
    public Page<ProductDTO> getUserPage(Pageable pageable) {
        return productService.getAllPage(pageable);
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductDTO> findByIdCategory(@PathVariable String categoryId) {
        return productService.findByCategoryId(categoryId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        productService.delete(id);
    }

    @GetMapping("/identifier/{productIdentifier}")
    public ProductDTO getProductByIdentifier(@PathVariable String productIdentifier) {
        return productService.findByIdentifier(productIdentifier);
    }

}
