package com.felipe.api.shoppingapi.shoppingapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/shopping")
@RequiredArgsConstructor
public class ShoppingController {
    
    public final ShoppingService shoppingService;

    @GetMapping
    public List<ShoppingDTO> getAll() {
        return shoppingService.getAll();
    }

    @GetMapping("/{id}")
    public ShopDTO findById(@PathVariable String id) {
        return shopService.findById(id);
    }

    @GetMapping("/shopByUser")
    public List<ShopDTO> findByUser(@RequestParam(name = "userIdentifier", required = true) String userIdentifier) {
        return shopService.findByUser(userIdentifier);
    }

    @GetMapping("/shopByDate")
    public List<ShopDTO> findByDate(@RequestParam(name = "startDate", required = true) LocalDateTime startDate, @RequestParam(name = "endDate", required = false) LocalDateTime endDate) {
        return shopService.findByDate(startDate, endDate);
    }
    
    @GetMapping("/product/{productIdentifier}")
    public List<ShopDTO> findByProductId(@PathVariable String productIdentifier) {
        return shopService.findByProductId(productIdentifier);
    }

    @GetMapping("/report")
    public List<ShopDTO> generateReport(@RequestParam(name = "startDate", required = true) LocalDateTime startDate, @RequestParam(name = "endDate", required = false) LocalDateTime endDate) {
        return shopService.findByDate(startDate, endDate);
    }

    @GetMapping("/search")
    public List<ShopDTO> searchShops(@RequestParam(name = "startDate", required = true) LocalDateTime startDate,
                                       @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
                                       @RequestParam(name = "minValue", required = false) Integer minValue) {
        return shopService.searchShops(startDate, endDate, minValue);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShopDTO save(@RequestBody ShopDTO shopDTO) {
        return shopService.save(shopDTO);
    }
    
}