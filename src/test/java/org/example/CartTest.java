package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {
    Cart myCart;

    @BeforeEach
    void setUp() {
        Product product1 = new Product("1", "칫솔", 1000);
        Product product2 = new Product("2", "치약", 2000);
        Product product3 = new Product("3", "안약", 3000);

        // 장바구니 생성
        myCart = new Cart();

        myCart.addProduct(product1, 2);
        myCart.addProduct(product2, 3);
        myCart.addProduct(product3, 5);
    }

    @Test
    @DisplayName("showItems() 메소드 테스트")
    void showItemsTest() {
        String dest = "1 : 칫솔 : 2개\n2 : 치약 : 3개\n3 : 안약 : 5개";
        assertEquals(dest, myCart.showItems());
    }

    @Test
    @DisplayName("showItemsByForExpression() 메소드 테스트")
    void showItemsByForExpressionTest() {
        String dest = "1 : 칫솔 : 2개\n2 : 치약 : 3개\n3 : 안약 : 5개";
        assertEquals(dest, myCart.showItemsByForExpression());
    }

    @Test
    @DisplayName("showItemsByStream() 메소드 테스트")
    void showItemsByStreamTest() {
        String dest = "1 : 칫솔 : 2개\n2 : 치약 : 3개\n3 : 안약 : 5개";
        assertEquals(dest, myCart.showItemsByStream());
    }

    @Test
    @DisplayName("addProduct() 메소드 테스트 - 이름이 같은데 키가 다른경우 다르게 인식")
    void addProductByDifferenceNameTest(){
        Product product4 = new Product("4", "치약", 2000);
        myCart.addProduct(product4, 10);
        String dest = "1 : 칫솔 : 2개\n2 : 치약 : 3개\n3 : 안약 : 5개\n4 : 치약 : 10개";
        assertEquals(dest, myCart.showItems());
    }

    @Test
    @DisplayName("addProduct() 메소드 테스트 - 키와 이름이 같은데 가격이 다른경우 다르게 인식")
    void addProductByDifferencePriceTest(){
        Product product4 = new Product("2", "치약", 70000);
        myCart.addProduct(product4, 10);
        String dest = "1 : 칫솔 : 2개\n2 : 치약 : 3개\n2 : 치약 : 10개\n3 : 안약 : 5개";
        assertEquals(dest, myCart.showItems());
    }

    @Test
    @DisplayName("addProduct() 메소드 테스트 - 같은 product일 경우 수량 증가")
    void addProductTest(){
        Product product4 = new Product("3", "안약", 3000);
        myCart.addProduct(product4, 10);
        String dest = "1 : 칫솔 : 2개\n2 : 치약 : 3개\n3 : 안약 : 15개";
        assertEquals(dest, myCart.showItems());
    }

    @Test
    @DisplayName("addProductByContainsKey() 메소드 테스트 - 같은 product일 경우 수량 증가")
    void addProductByContainsKeyTest(){
        Product product4 = new Product("3", "안약", 3000);
        myCart.addProductByContainsKey(product4, 10);
        String dest = "1 : 칫솔 : 2개\n2 : 치약 : 3개\n3 : 안약 : 15개";
        assertEquals(dest, myCart.showItems());
    }

    @Test
    @DisplayName("addProductByGet() 메소드 테스트 - 같은 product일 경우 수량 증가")
    void addProductByGetTest(){
        Product product4 = new Product("3", "안약", 3000);
        myCart.addProductByGet(product4, 10);
        String dest = "1 : 칫솔 : 2개\n2 : 치약 : 3개\n3 : 안약 : 15개";
        assertEquals(dest, myCart.showItems());
    }

    @Test
    @DisplayName("addProductByMerge() 메소드 테스트 - 같은 product일 경우 수량 증가")
    void addProductByMergeTest(){
        Product product4 = new Product("3", "안약", 3000);
        myCart.addProductByMerge(product4, 10);
        String dest = "1 : 칫솔 : 2개\n2 : 치약 : 3개\n3 : 안약 : 15개";
        assertEquals(dest, myCart.showItems());
    }

    @Test
    @DisplayName("addProductByPutIfAbsent() 메소드 테스트 - 같은 product일 경우 수량 증가")
    void addProductByPutIfAbsentTest(){
        Product product4 = new Product("3", "안약", 3000);
        myCart.addProductByPutIfAbsent(product4, 10);
        String dest = "1 : 칫솔 : 2개\n2 : 치약 : 3개\n3 : 안약 : 15개";
        assertEquals(dest, myCart.showItems());
    }
}
