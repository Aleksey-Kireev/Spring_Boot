package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class DiscountedProduct extends Product {
    private final UUID id;
    private final int basePrice;
    private final int discount;

    public DiscountedProduct(String productName, int basePrice, int discount, UUID id) throws IllegalArgumentException {
        super(productName);
        if (basePrice < 0) {
            throw new IllegalArgumentException("Цена должна быть больше `0`");
        } else if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка должна быть в диапазоне от 0 до 100 %");
        }
        this.basePrice = basePrice;
        this.discount = discount;
        this.id = id;
    }

    @Override
    public Boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {

        return String.format("< ID - %s  - %s со скидкой : %d руб. (скидка %d %%)", id, getProductName(), getPrice(),
                discount);
    }

    @Override
    public int getPrice() {
        return basePrice - (basePrice * discount / 100);
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
        return "Product Discount";
    }

    @Override
    public String getName() {
        return getProductName();
    }
}
