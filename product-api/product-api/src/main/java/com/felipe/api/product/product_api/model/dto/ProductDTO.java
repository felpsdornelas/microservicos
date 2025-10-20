package com.felipe.api.product.product_api.model.dto;

import org.springframework.data.annotation.Id;

import com.felipe.api.product.product_api.model.Category;
import com.felipe.api.product.product_api.model.Product;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
     @Id
     private String id;

     @NotBlank(message = "Necessário a identificação do produto")
     private String productIdentifier;

     @NotBlank (message = "Nome é obrigatório")
     private String nome;

     private String descricao;
     private Double preco;
     private Category category;

     public static ProductDTO convert(Product product) {
          ProductDTO productDTO = new ProductDTO();
          productDTO.setId(product.getId());
          productDTO.setProductIdentifier(product.getProductIdentifier());
          productDTO.setNome(product.getNome());
          productDTO.setDescricao(product.getDescricao());
          productDTO.setPreco(product.getPreco());
          productDTO.setCategory(product.getCategory());
          return productDTO;
     }
}
