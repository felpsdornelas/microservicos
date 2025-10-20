package com.felipe.api.product.product_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.felipe.api.product.product_api.model.dto.CategoryDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
     @Id
     private String id;

     @Field("nome")
     private String nome;

     public static Category convert(CategoryDTO categoryDTO) {
          Category category = new Category();
          category.setId(categoryDTO.getId());
          category.setNome(categoryDTO.getNome());
          return category;
     }
}
