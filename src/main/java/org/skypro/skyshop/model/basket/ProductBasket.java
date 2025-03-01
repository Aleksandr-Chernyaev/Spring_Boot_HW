package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@SessionScope
public class ProductBasket implements Serializable {
    private final Map<UUID, Integer> products = new HashMap<>();

    public void addProduct(UUID id) {
        products.put(id, products.getOrDefault(id, 0) + 1);
    }

    public Map<UUID, Integer> getProducts() {
        return Collections.unmodifiableMap(products);
    }

    public void removeProduct(UUID id) {
        products.remove(id);
    }
}