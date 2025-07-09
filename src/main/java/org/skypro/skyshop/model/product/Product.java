package org.skypro.skyshop.model.product;

import java.util.Objects;
import java.util.UUID;

import org.skypro.skyshop.model.search.Searchable;

//public class Product {
public abstract class Product implements Searchable {

//    private final UUID id;
    private final String productName;

    public abstract Boolean isSpecial();

    public Product(String productName) throws IllegalArgumentException {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Неизвестное или неправильное имя продукта");
        }
        this.productName = productName;
//        this.id = id;

    }

    public String getProductName() {
        return productName;
    }

    public abstract int getPrice();

    /*@Override
    public UUID getId() {
        return id;
    }*/

    @Override
    public String toString() {
        return String.format("< %s : %d руб.", getProductName(), getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productName);
    }
}
