package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> productStorage;
    private final Map<UUID, Article> articleStorage;

    public StorageService() {
        this.productStorage = new HashMap<>();
        this.articleStorage = new HashMap<>();
        initializeTestData();
    }

    private void initializeTestData() {

        productStorage.put(UUID.randomUUID(), new SimpleProduct("Очки", 100, false, UUID.randomUUID()));
        productStorage.put(UUID.randomUUID(), new SimpleProduct("Диван", 15800, true, UUID.randomUUID()));
        productStorage.put(UUID.randomUUID(), new DiscountedProduct("Пахлава", 474, 20, UUID.randomUUID()));
        productStorage.put(UUID.randomUUID(), new FixPriceProduct("Клавиатура", UUID.randomUUID()));


        articleStorage.put(UUID.randomUUID(), new Article("Статья о животных", "Зебры", UUID.randomUUID()));
        articleStorage.put(UUID.randomUUID(), new Article("Первая статья", "описание", UUID.randomUUID()));
    }

    public Collection<Product> getAllProducts() {
        return productStorage.values();
    }

    public Collection<Article> getAllArticles() {
        return articleStorage.values();
    }

    public Collection<Searchable> getAllSearchables() {
        Collection<Searchable> searchables = new ArrayList<>();
        searchables.addAll(productStorage.values());
        searchables.addAll(articleStorage.values());
        return searchables;
    }
}