package org.skypro.skyshop.model.search;

import java.util.UUID;

public class SearchResult {

    private final String name;
    private final UUID id;
    private final String contentType;

    private SearchResult(UUID id, String name, String contentType) {
        this.name = name;
        this.id = id;
        this.contentType = contentType;
    }

    public static SearchResult fromSearchable(Searchable searchable) {
        return new SearchResult(searchable.getId(), searchable.getName(), searchable.getStringRepresentation());
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public String getStringRepresentation() {
        return contentType;
    }
}
