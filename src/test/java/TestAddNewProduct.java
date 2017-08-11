import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@Test
public class TestAddNewProduct extends BaseTest {

    public void testNewProductAdding() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        openAdminPage();
        driver.findElement(By.cssSelector(
                "[href='http://localhost/litecart/admin/?app=catalog&doc=catalog']")).click();
        driver.findElement(By.cssSelector(
                "[href='http://localhost/litecart/admin/?category_id=0&app=catalog&doc=edit_product']")).click();
        WebElement tabs = driver.findElement(By.cssSelector(".tabs"));
        tabs.findElement(By.cssSelector("[name='status']")).click();
        Random rand = new Random();
        String  n = Integer.toString(rand.nextInt(500) + 1);
        String productName = "Product" + n;
        tabs.findElement(By.cssSelector("[name='name[en]']")).sendKeys(productName);
        tabs.findElement(By.cssSelector("[name='code']")).sendKeys("Code");
        tabs.findElement(By.cssSelector("[type='checkbox']")).click();
        tabs.findElement(By.cssSelector("[data-name='Subcategory']")).click();
        tabs.findElement(By.cssSelector("[name='quantity']")).sendKeys("1");
        Path path = Paths.get(".\\book.jpg");
        String absolutePath = path.normalize().toAbsolutePath().toString();

        WebElement upload = tabs.findElement(By.cssSelector("[name='new_images[]']"));
        upload.sendKeys(absolutePath);

        tabs.findElement(By.cssSelector("[name='date_valid_from']")).sendKeys(Keys.HOME + "10.08.2017");
        tabs.findElement(By.cssSelector("[name='date_valid_to']")).sendKeys(Keys.HOME + "20.08.2017");

        tabs.findElement(By.cssSelector("[href='#tab-information']")).click();
        wait.until(presenceOfElementLocated(By.cssSelector("[name='manufacturer_id']")));
        Select manufacturer = new Select(tabs.findElement(By.cssSelector("[name='manufacturer_id']")));
        manufacturer.selectByIndex(1);
        tabs.findElement(By.cssSelector("[name='keywords']")).sendKeys("key");
        tabs.findElement(By.cssSelector("[name='short_description[en]']")).sendKeys("key");
        tabs.findElement(By.cssSelector(".trumbowyg-editor")).sendKeys("Description");
        tabs.findElement(By.cssSelector("[name='head_title[en]']")).sendKeys("title");
        tabs.findElement(By.cssSelector("[name='meta_description[en]']")).sendKeys("meta");
        tabs.findElement(By.cssSelector("[href='#tab-prices']")).click();
        wait.until(presenceOfElementLocated(By.cssSelector("[name='purchase_price']")));
        tabs.findElement(By.cssSelector("[name='purchase_price']")).sendKeys("1");
        Select currency = new Select(tabs.findElement(By.cssSelector("[name='purchase_price_currency_code']")));
        currency.selectByIndex(1);
        tabs.findElement(By.cssSelector("[name='gross_prices[USD]']")).sendKeys("1");
        tabs.findElement(By.cssSelector("[name='gross_prices[EUR]']")).sendKeys("1");
        driver.findElement(By.cssSelector("[name='save']")).click();
        driver.findElement(By.linkText(productName));
    }
}
