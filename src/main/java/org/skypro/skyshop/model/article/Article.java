package org.skypro.skyshop.model.article;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {
    private final String titleName;
    private final String text;
    private final UUID id;


    public Article(String titleName, String text, UUID id) {
        this.titleName = titleName;
        this.text = text;
        this.id = id;
    }

    @JsonIgnore
    public String getTitleName() {
        return titleName;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return titleName;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @JsonIgnore
    @Override
    public String getSearchTerm() {
        return getTitleName() + ". " + getText();
    }

    @JsonIgnore
    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(titleName, article.titleName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titleName);
    }

    @Override
    public String getName() {
        return titleName;
    }

    public static class SearchComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            int searchCompare = Integer.compare(s2.getSearchTerm().length(), s1.getSearchTerm().length());
            if (searchCompare == 0) {
                return s1.getSearchTerm().compareTo(s2.getSearchTerm());
            }
            return searchCompare;
        }
    }

}
