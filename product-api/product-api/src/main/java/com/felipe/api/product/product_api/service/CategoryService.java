package com.felipe.api.product.product_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.felipe.api.product.product_api.model.Category;
import com.felipe.api.product.product_api.model.Product;
import com.felipe.api.product.product_api.model.dto.CategoryDTO;
import com.felipe.api.product.product_api.model.dto.ProductDTO;
import com.felipe.api.product.product_api.repository.CategoryRepository;
import com.felipe.api.product.product_api.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

     private final CategoryRepository categoryRepository;

     public List<CategoryDTO> getAll() {
          List<Category> categorias = categoryRepository.findAll();
          return categorias.stream()
                    .map(CategoryDTO::convert)
                    .collect(Collectors.toList());
     }

     public CategoryDTO save(CategoryDTO categoryDTO) {
          Category catgeory = categoryRepository.save(Category.convert(categoryDTO));
          return CategoryDTO.convert(catgeory);
     }

     public CategoryDTO update(String categoryId, CategoryDTO categoryDTO) {

          // Verifica se a cartegoria existe
          Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrado"));

          // Atualiza o produto
          category.setNome(categoryDTO.getNome());

          // salva
          Category categoryUpdate = categoryRepository.save(category);
          return CategoryDTO.convert(categoryUpdate);
     }

     public void delete(String id) {
          Category category = categoryRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
          categoryRepository.delete(category);
     }

     public Page<CategoryDTO> getAllPage(Pageable page) {
          Page<Category> categorys = categoryRepository.findAll(page);
          return categorys.map(CategoryDTO::convert);
     }
}
