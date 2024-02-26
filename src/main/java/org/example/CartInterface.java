package org.example;

public interface CartInterface<T extends Product> {
    String showItems();
    void addProduct(T product, int count);
    void removeProduct(T product, int count);
}
