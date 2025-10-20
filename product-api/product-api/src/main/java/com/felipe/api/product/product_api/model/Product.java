package com.felipe.api.product.product_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.felipe.api.product.product_api.model.dto.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product")
public class Product {
     @Id
     private String id;

     @Field("product_identifier")
     private String productIdentifier;

     @Field("nome")
     private String nome;

     @Field("descricao")
     private String descricao;

     @Field("preco")
     private Double preco;

     @DBRef
     @Field("category") 
     private Category category;

public static Product convert(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductIdentifier(productDTO.getProductIdentifier());
        product.setNome(productDTO.getNome());
        product.setDescricao(productDTO.getDescricao());
        product.setPreco(productDTO.getPreco());
        product.setCategory(productDTO.getCategory());
        return product;
        
    }

}
