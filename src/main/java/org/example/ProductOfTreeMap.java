package org.example;

public class ProductOfTreeMap extends Product implements Comparable<ProductOfTreeMap> {
    public ProductOfTreeMap(String key, String name, int price) {
        super(key, name, price);
    }

    @Override
    public int compareTo(ProductOfTreeMap other) {
        int keyComparison = this.getKey().compareTo(other.getKey());
        if (keyComparison != 0) {
            return keyComparison;
        }

        int nameComparison = this.getName().compareTo(other.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }

        return Integer.compare(this.getPrice(), other.getPrice());
    }
}
