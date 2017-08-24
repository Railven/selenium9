package PageObjectExample.app.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getTableItem(){
        WebElement summaryTable = driver.findElement(By.cssSelector("#box-checkout-summary"));
        return summaryTable.findElement(By.cssSelector(".item"));
    }

    public void waitOfDisappearingItem(WebElement element) {
        wait.until(stalenessOf(element));
    }
    @FindBy(css = "[name='remove_cart_item']")
    public WebElement removeButton;
}