package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public List<Searchable> search(String query) {
        String queryLower = query.toLowerCase();
        return storageService.getAll().stream()
                .filter(item -> item.getStringRepresentation().toLowerCase().contains(queryLower))
                .toList();
    }


}
