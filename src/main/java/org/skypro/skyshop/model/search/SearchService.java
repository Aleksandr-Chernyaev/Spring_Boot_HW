package org.skypro.skyshop.model.search;

import org.skypro.skyshop.service.StorageService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Collection<SearchResult> search(String pattern) {
        return storageService.getAllSearchables().stream()
                .filter(searchable -> searchable.getName().toLowerCase().contains(pattern.toLowerCase()))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toList());
    }
}