package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class SimpleProduct extends Product {

    private final int price;
    private final UUID id;

    public SimpleProduct(String productName, int price, UUID id) throws IllegalArgumentException {
        super(productName);
        if (price < 0) {
            throw new IllegalArgumentException("Цена должна быть больше  `0`");
        }
        this.id = id;
        this.price = price;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @JsonIgnore
    @Override
    public String getSearchTerm() {
        return getProductName();
    }

    @JsonIgnore
    @Override
    public String getContentType() {
        return "Product Simple";

    }

    @Override
    public String getName() {
        return getProductName();
    }

    @Override
    public Boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int getPrice() {
        return price;
    }
}
