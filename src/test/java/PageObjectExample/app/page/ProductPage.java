package PageObjectExample.app.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectSizeFromIndex(int i) {
        Select size = new Select(driver.findElement(By.cssSelector("[name='options[Size]']")));
        size.selectByIndex(i);
    }

    public void waitForAddingProductInBasket(WebElement quantity, int i) {
        String a = Integer.toString(i);
        wait.until(ExpectedConditions.textToBePresentInElement(quantity, a));
    }

    @FindBy(css = "span.quantity")
    public WebElement quantity;

    @FindBy(css = "[name='add_cart_product']")
    public WebElement addProductButton;

    @FindBy(css = "[href='/litecart/']")
    public WebElement mainPageLink;
}
