package PageObjectExample.app.tests;

import org.testng.annotations.Test;


public class TestAddingProductsInBasketPageObject extends BaseTestPageObject {
    @Test
    public void testAddingProductInBasket() {
        Integer countOfProducts = 4;
        app.addProductsInBasket(countOfProducts);
        app.goToBasket();
        app.removeProductsFromBasket(countOfProducts);
    }
}
