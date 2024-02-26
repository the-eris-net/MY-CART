package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("TreeMapCart 클래스 테스트 - HashMap이 아니며 Product를 비교해서 정렬한다.")
public class TreeMapCartTest {
    /*
     * 원래는 테스트시에 interface로 한다.
     */
    CartInterface myCart;

    @BeforeEach
    void setUp() {
        Product product3 = new ProductOfTreeMap("3", "안약", 3000);
        Product product1 = new ProductOfTreeMap("1", "칫솔", 1000);
        Product product2 = new ProductOfTreeMap("2", "치약", 2000);

        // 장바구니 생성
        myCart = new TreeMapCart();

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
    @DisplayName("addProduct() 메소드 테스트 - 이름이 같은데 키가 다른경우 다르게 인식")
    void addProductByDifferenceNameTest(){
        Product product4 = new ProductOfTreeMap("4", "치약", 2000);
        myCart.addProduct(product4, 10);
        String dest = "1 : 칫솔 : 2개\n2 : 치약 : 3개\n3 : 안약 : 5개\n4 : 치약 : 10개";
        assertEquals(dest, myCart.showItems());
    }

    @Test
    @DisplayName("addProduct() 메소드 테스트 - 키와 이름이 같은데 가격이 다른경우 다르게 인식")
    void addProductByDifferencePriceTest(){
        Product product4 = new ProductOfTreeMap("2", "치약", 70000);
        myCart.addProduct(product4, 10);
        String dest = "1 : 칫솔 : 2개\n2 : 치약 : 3개\n2 : 치약 : 10개\n3 : 안약 : 5개";
        assertEquals(dest, myCart.showItems());
    }

    @Test
    @DisplayName("addProduct() 메소드 테스트 - 같은 product일 경우 수량 증가")
    void addProductTest(){
        Product product4 = new ProductOfTreeMap("3", "안약", 3000);
        myCart.addProduct(product4, 10);
        String dest = "1 : 칫솔 : 2개\n2 : 치약 : 3개\n3 : 안약 : 15개";
        assertEquals(dest, myCart.showItems());
    }
}
