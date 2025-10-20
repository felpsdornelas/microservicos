package com.felipe.api.product.product_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.felipe.api.product.product_api.model.Product;
import com.felipe.api.product.product_api.model.dto.ProductDTO;
import com.felipe.api.product.product_api.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

     private final ProductRepository productRepository;     
     private final ProductRepository categoryRepository;     

     public List<ProductDTO> getAll() {
          List<Product> produtos = productRepository.findAll();
          return produtos.stream()
                    .map(ProductDTO::convert)
                    .collect(Collectors.toList());
     }

     public ProductDTO findById(String productId) {
          Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
          return ProductDTO.convert(product);
     }

     public ProductDTO save(ProductDTO productDTO) {
          Product product = productRepository.save(Product.convert(productDTO));
          Product saveProduct = productRepository.findById(product.getId()).orElseThrow(() -> new RuntimeException());
          return ProductDTO.convert(saveProduct);
     }

     public ProductDTO update(String productId, ProductDTO productDTO) {

          // Verifica se o produto existe
          Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

          // Atualiza o produto
          product.setNome(productDTO.getNome());
          product.setDescricao(productDTO.getDescricao());
          product.setPreco(productDTO.getPreco());

          // salva
          Product productUpdate = productRepository.save(product);
          return ProductDTO.convert(productUpdate);
     }

     public Page<ProductDTO> getAllPage(Pageable page) {
          Page<Product> products = productRepository.findAll(page);
          return products.map(ProductDTO::convert);
     }

     public List<ProductDTO> findByCategoryId(String categoryId) {
          List<Product> products = productRepository.findByCategory_Id(categoryId);
          if (products.isEmpty()) {
               throw new RuntimeException("Nenhum produto encontrado para esta categoria");
          }
          return products.stream()
                    .map(ProductDTO::convert)
                    .collect(Collectors.toList());
     }

     public void delete(String id) {
          Product product = productRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
          productRepository.delete(product);
     }

     public ProductDTO findByIdentifier(String productIdentifier) {
          Product product = productRepository.findByProductIdentifier(productIdentifier)
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
          return ProductDTO.convert(product);
     }
}
