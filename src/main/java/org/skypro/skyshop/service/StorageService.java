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
        UUID productId1 = UUID.randomUUID();
        productStorage.put(productId1, new SimpleProduct("Очки", 100, false, productId1));

        UUID productId2 = UUID.randomUUID();
        productStorage.put(productId2, new SimpleProduct("Диван", 15800, true, productId2));

        UUID productId3 = UUID.randomUUID();
        productStorage.put(productId3, new DiscountedProduct("Пахлава", 474, 20, productId3));

        UUID productId4 = UUID.randomUUID();
        productStorage.put(productId4, new FixPriceProduct("Клавиатура", productId4));

        UUID articleId1 = UUID.randomUUID();
        articleStorage.put(articleId1, new Article("Статья о животных", "Зебры", articleId1));

        UUID articleId2 = UUID.randomUUID();
        articleStorage.put(articleId2, new Article("Первая статья", "описание", articleId2));
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

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(productStorage.get(id));
    }
}