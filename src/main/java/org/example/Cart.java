package org.example;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Cart implements CartInterface<Product> {
    private final Map<Product, Integer> productCountMap = new HashMap<>();

    @Override
    public String showItems() {
//        return showItemsByForExpression();
        return showItemsByStream();
    }

    String showItemsByForExpression() {
        List<String> products = new ArrayList<>();
        List<Entry<Product, Integer>> entries = new ArrayList<>(productCountMap.entrySet().stream().toList());
        entries.sort(getComparing());
        for (var entry : entries) {
            products.add(entry.getKey().getKey() + " : " + entry.getKey().getName() + " : " + entry.getValue() + "개");
        }
        return String.join("\n", products);
    }

    String showItemsByStream() {
        return productCountMap.entrySet().stream()
                .sorted(getComparing())
                .map(entry -> entry.getKey().getKey() + " : " + entry.getKey().getName() + " : " + entry.getValue() + "개")
                .collect(Collectors.joining("\n"));
    }

    private Comparator<Entry<Product, Integer>> getComparing() {
        return Comparator.comparing((Entry<Product, Integer> entry) -> entry.getKey().getKey())
                .thenComparing(entry -> entry.getKey().getName())
                .thenComparing(entry -> entry.getKey().getPrice());
    }

    @Override
    public void addProduct(Product product, int count) {
//        addProductByContainsKey(product, count);
//        addProductByGet(product, count);
//        addProductByMerge(product, count);
        addProductByPutIfAbsent(product, count);
    }

    @Override
    public void removeProduct(Product product, int count) {
        productCountMap.put(product, productCountMap.get(product) - count);
        if (productCountMap.get(product) <= 0) {
            productCountMap.remove(product);
        }
    }

    void addProductByContainsKey(Product product, int count) {
        if (!productCountMap.containsKey(product)) {
            productCountMap.put(product, 0);
        }
        productCountMap.put(product, productCountMap.get(product) + count);
    }

    void addProductByGet(Product product, int count) {
        if (productCountMap.get(product) == null) {
            productCountMap.put(product, 0);
        }
        productCountMap.put(product, productCountMap.get(product) + count);
    }

    void addProductByMerge(Product product, int count) {
        productCountMap.merge(product, count, Integer::sum);
    }

    void addProductByPutIfAbsent(Product product, int count) {
        productCountMap.putIfAbsent(product, 0);
        productCountMap.put(product, productCountMap.get(product) + count);
    }
}
