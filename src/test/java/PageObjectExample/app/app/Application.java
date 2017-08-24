package PageObjectExample.app.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObjectExample.app.page.CartPage;
import PageObjectExample.app.page.MainPage;
import PageObjectExample.app.page.ProductPage;

public class Application {

    private WebDriver driver;

    private MainPage mainPage;
    private CartPage cartPage;
    private ProductPage productPage;

    public Application() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    public void quit() {
        driver.quit();
    }

    public void addProductsInBasket(Integer count) {
        mainPage.open();
        for (int i = 1; i < count; i++) {
            mainPage.goToProductPage();
            productPage.selectSizeFromIndex(i);
            WebElement quantity = productPage.quantity;
            productPage.addProductButton.click();
            productPage.waitForAddingProductInBasket(quantity, i);
            productPage.mainPageLink.click();
        }
    }

    public void goToBasket() {
        mainPage.cartLink.click();
    }

    public void removeProductsFromBasket(Integer count) {
        for (int i = 1; i < count; i++) {
            WebElement tableItem = cartPage.getTableItem();
            cartPage.removeButton.click();
            cartPage.waitOfDisappearingItem(tableItem);
        }
    }
}
