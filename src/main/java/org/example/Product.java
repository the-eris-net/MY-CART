package org.example;

import java.util.Objects;

public class Product {
    private final String key;
    private final String name;
    private final int price;

    public Product(String key, String name, int price) {
        this.key = key;
        this.name = name;
        this.price = price;
    }
    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price
                && Objects.equals(key, product.key)
                && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
