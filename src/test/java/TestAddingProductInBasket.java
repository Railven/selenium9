import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import org.testng.annotations.Test;

public class TestAddingProductInBasket extends BaseTest {
    @Test
    public void testAddingProductInBasket() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        openMainPage();
        for (int i = 1; i < 4; i++) {
            WebElement productList = driver.findElement(By.cssSelector("#box-campaigns"));
            productList.findElement(By.cssSelector(".image-wrapper")).click();
            Select size = new Select(driver.findElement(By.cssSelector("[name='options[Size]']")));
            size.selectByIndex(i);
            WebElement cart = driver.findElement(By.cssSelector("#cart"));
            WebElement quantity = cart.findElement(By.cssSelector("span.quantity"));
            driver.findElement(By.cssSelector("[name='add_cart_product']")).click();
            String a = Integer.toString(i);
            wait.until(ExpectedConditions.textToBePresentInElement(quantity, a));
            driver.findElement(By.cssSelector("[href='/litecart/']")).click();
        }
        driver.findElement(By.cssSelector("[href='http://localhost/litecart/en/checkout']")).click();
        for (int i = 0; i < 3; i++) {
            WebElement summaryTable = driver.findElement(By.cssSelector("#box-checkout-summary"));
            WebElement tableItem = summaryTable.findElement(By.cssSelector(".item"));
            driver.findElement(By.cssSelector("[name='remove_cart_item']")).click();
            wait.until(stalenessOf(tableItem));
        }
    }
}
