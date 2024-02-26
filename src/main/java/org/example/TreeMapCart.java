package org.example;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TreeMapCart implements CartInterface<ProductOfTreeMap> {
    private final Map<ProductOfTreeMap, Integer> productCountMap = new TreeMap<>();

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
    public void addProduct(ProductOfTreeMap product, int count) {
        addProductByPutIfAbsent(product, count);
    }

    @Override
    public void removeProduct(ProductOfTreeMap product, int count) {
        productCountMap.put(product, productCountMap.get(product) - count);
        if (productCountMap.get(product) <= 0) {
            productCountMap.remove(product);
        }
    }

    private void addProductByPutIfAbsent(ProductOfTreeMap product, int count) {
        productCountMap.putIfAbsent(product, 0);
        productCountMap.put(product, productCountMap.get(product) + count);
    }
}
