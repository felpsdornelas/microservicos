package com.felipe.api.product.product_api.model.dto;

import com.felipe.api.product.product_api.model.Category;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
     private String id;
     @NotBlank (message = "Nome é obrigatório")
     private String nome;
     
     public static CategoryDTO convert(Category category) {
          CategoryDTO categoryDTO = new CategoryDTO();
          categoryDTO.setId(category.getId());
          categoryDTO.setNome(category.getNome());
          return categoryDTO;
     }
}
