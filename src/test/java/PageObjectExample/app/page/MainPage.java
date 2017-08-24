package PageObjectExample.app.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("http://localhost/litecart/");
    }

    public void goToProductPage() {
        WebElement productList = driver.findElement(By.cssSelector("#box-campaigns"));
        productList.findElement(By.cssSelector(".image-wrapper")).click();
    }

    @FindBy(css = "#box-campaigns.image-wrapper")
    public WebElement product;

    @FindBy(css = "[href='http://localhost/litecart/en/checkout']")
    public WebElement cartLink;
}
