package com.felipe.api.shoppingapi.shoppingapi.service;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.felipe.api.shoppingapi.shoppingapi.model.dto.ShoppingDTO;
import com.felipe.api.shoppingapi.shoppingapi.model.Shopping;
import com.felipe.api.shoppingapi.shoppingapi.model.Item;
import com.felipe.api.shoppingapi.shoppingapi.repository.ShoppingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShoppingService {
    
    private final ShoppingRepository shoppingRepository;

    public List<ShoppingDTO> getAll() {
        List<ShoppingDTO> shopping = shoppingRepository.findAll()
                                .stream()
                                .map(ShoppingDTO::convertToDto)
                                .collect(Collectors.toList());
        return shopping;
    }

    public ShoppingDTO findById(String id) {
        Shopping shop = shoppingRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return ShoppingDTO.convertToDto(shop);
    }

    public ShoppingDTO save(ShoppingDTO shopDTO) {
        Shopping shop = new Shopping();
        shop.setUserIdentifier(shopDTO.getUserIdentifier());
        shop.setDate(LocalDateTime.now());
        shop.setItems(shopDTO.getItems().stream().map(Item::convertToEntity).collect(Collectors.toList()));

        Integer totalItems = shop.getItems().size();
        shop.setTotal(totalItems);

        shop = shoppingRepository.save(shop);

        return ShoppingDTO.convertToDto(shop);
    }

    public List<ShoppingDTO> findByUser(String userIdentifier) {
        List<Shopping> shop = shoppingRepository.queryByUserIdentifierLike(userIdentifier);
        return shop.stream()
                    .map(ShoppingDTO::convertToDto)
                    .collect(Collectors.toList());
    }

    public List<ShoppingDTO> findByDate(LocalDateTime startDate, LocalDateTime endDate) {
        List<Shopping> shop = shoppingRepository.queryByDateBetween(startDate, endDate);
        return shop.stream()
                    .map(ShoppingDTO::convertToDto)
                    .collect(Collectors.toList());
    }

    public List<ShoppingDTO> findByProductId(String productIdentifier) {
        List<Shopping> shop = shoppingRepository.findByItems_ProductIdentifier(productIdentifier);
        return shop.stream()
                    .map(ShoppingDTO::convertToDto)
                    .collect(Collectors.toList());
    }

    public List<ShoppingDTO> searchShops(LocalDateTime startDate, LocalDateTime endDate, Integer minValue) {
        List<Shopping> shops = shoppingRepository.findByDateBetweenAndTotalGreaterThanEqual(startDate, endDate, minValue);
        return shops.stream()
                .map(ShoppingDTO::convertToDto)
                .collect(Collectors.toList());
    }
}
