package org.skypro.skyshop.model.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.directory.SearchResult;
import java.util.Collection;
import java.util.List;

@RestController
public class ShopController {
    private final StorageService storageService;

    public ShopController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/products")
    public Collection<Product> getAllProducts() {
        return storageService.returnProducts();
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticles() {
        return storageService.returnArticles();
    }

    /*@GetMapping("/search")
    public List<SearchResult> findPattern(@RequestParam String pattern) {
        return this.storageService.getAllSearchable().stream()
                .filter(searchable -> searchable.getSearchTerm().toLowerCase().contains(pattern.toLowerCase()))
                .map(SearchResult::fromSearchable).collect(Collectors.toList());
    }*/
}
