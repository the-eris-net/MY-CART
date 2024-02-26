package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class LinkedHashMapCart implements CartInterface<Product> {
    private final Map<Product, Integer> productCountMap = new LinkedHashMap<>();

    @Override
    public String showItems() {
        return showItemsByStream();
    }

    private String showItemsByStream() {
        return productCountMap.entrySet().stream()
                .map(entry -> entry.getKey().getKey() + " : " + entry.getKey().getName() + " : " + entry.getValue() + "개")
                .collect(Collectors.joining("\n"));
    }

    @Override
    public void addProduct(Product product, int count) {
        addProductByPutIfAbsent(product, count);
    }

    @Override
    public void removeProduct(Product product, int count) {
        productCountMap.put(product, productCountMap.get(product) - count);
        if (productCountMap.get(product) <= 0) {
            productCountMap.remove(product);
        }
    }

    private void addProductByPutIfAbsent(Product product, int count) {
        productCountMap.putIfAbsent(product, 0);
        productCountMap.put(product, productCountMap.get(product) + count);
    }
}
