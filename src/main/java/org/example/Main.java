package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // 상품 목록 생성
        Set<Product> productSet = new HashSet<>();
        // TODO: 상품 클래스를 생성하여 상품목록에 넣는다.
        Product product1 = new Product("1", "칫솔", 1000);
        Product product2 = new Product("2", "치약", 2000);
        Product product3 = new Product("3", "안약", 3000);

        productSet.add(product1);
        productSet.add(product2);
        productSet.add(product3);

        // 상품 목록 확인
        System.out.println("고유한 상품 목록:");
        for (Product product : productSet) {
            System.out.println(product);
        }

        // 장바구니 생성
        Cart myCart = new Cart();

        myCart.addProduct(product1, 2);
        myCart.addProduct(product2, 3);
        myCart.addProduct(product1, 5);
        myCart.addProduct(product3, 3);

        // 상품 장바구니에서 제거

        myCart.removeProduct(product1, 2);
        myCart.removeProduct(product2, 1);
        myCart.removeProduct(product3, 3);

        // 장바구니의 상품 모두 출력
        System.out.println("장바구니의 상품 모두 출력 : ");
        System.out.println(myCart.showItems());

        //추가테스트
        CsvReader reader = new CsvReader();
        System.out.println("resource csv 파일에서 읽어온 상품 목록:");
        List<Product> productsByResource = reader.readCsvByResource("dataByResource.csv");
        productsByResource.forEach(System.out::println);

        System.out.println("일반 경로 csv 파일에서 읽어온 상품 목록:");
        List<Product> productsByNormalPath = reader.readCsvByNormalPath("/Users/coeat/MY-CART/src/main/java/org/example/dataByNormalPath.csv");
        productsByNormalPath.forEach(System.out::println);

        productSet.addAll(productsByResource);
        productSet.addAll(productsByNormalPath);
        productSet.forEach(System.out::println);
    }
}