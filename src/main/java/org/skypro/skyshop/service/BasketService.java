package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addProductToBasket(UUID id) {
        Optional<Product> product = storageService.getProductById(id);
        if (!product.isPresent()) {
            throw new IllegalArgumentException("Товар не найден");
        }
        productBasket.addProduct(id);
    }

    public UserBasket getUserBasket() {
        Map<UUID, Integer> products = productBasket.getProducts();
        List<BasketItem> basketItems = products.entrySet().stream()
                .map(entry -> new BasketItem(storageService.getProductById(entry.getKey()).get(), entry.getValue()))
                .collect(Collectors.toList());

        double total = basketItems.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();

        return new UserBasket(basketItems, total);
    }
}