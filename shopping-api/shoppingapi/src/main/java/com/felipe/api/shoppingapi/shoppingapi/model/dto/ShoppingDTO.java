package com.felipe.api.shoppingapi.shoppingapi.model.dto;

import java.util.List;

import com.felipe.api.shoppingapi.shoppingapi.model.Shopping;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingDTO {
      private String id;

    @NotBlank(message = "O campo user_identifier não pode ser vazio ou nulo.")
    public String userIdentifier;

    @NotBlank(message = "O campo items não pode ser vazio ou nulo.")
    public List<ItemDTO> items;

    @PositiveOrZero(message = "O número total de itens não pode ser negativo.")
    public Integer total;

    public static ShoppingDTO convert(Shopping shopping) {
        ShoppingDTO shoppingDTO = new shoppingDTO();
        shoppingDTO.setUserIdentifier(shop.getUserIdentifier());
        shoppingDTO.setItems(shopping.getItems().stream().map(ItemDTO::convertToDTO).toList());
        shoppingDTO.setTotal(shopping.getTotal());
        return shoppingDTO;
    }
}
