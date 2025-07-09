package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class FixPriceProduct extends Product {

    private static final int FIX_PRICE = 100;
    private final UUID id;

    public FixPriceProduct(String productName, UUID id) {
        super(productName);
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("< %s c фиксированной ценой : Фиксированная цена  %d руб.", getProductName(), getPrice());
    }

    @Override
    public Boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
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
        return "Product FixPrice";
    }

    @Override
    public String getName() {
        return getProductName();
    }

}
