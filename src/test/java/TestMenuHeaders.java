import org.openqa.selenium.*;
import org.testng.annotations.Test;
import java.util.List;

public class TestMenuHeaders extends BaseTest {

    @Test
    public void testMenuHeaders() {
        driver.get("http://localhost/litecart/admin/login.php");
        String LogAndPass = "admin";
        driver.findElement(By.name("username")).sendKeys(LogAndPass);
        driver.findElement(By.name("password")).sendKeys(LogAndPass);
        WebElement element = driver.findElement(By.name("login"));
        element.click();

        List<WebElement> menuItems = driver.findElements(By.id("app-"));
        for (int i = 0; i < menuItems.size(); i++ ){
            menuItems = driver.findElements(By.id("app-"));
            menuItems.get(i).click();
            isElementPresent(driver, By.tagName("h1"));
            List<WebElement> items = driver.findElements(By.cssSelector(".docs .name"));
                for (int j = 0; j < items.size(); j++) {
                    items = driver.findElements(By.cssSelector(".docs .name"));
                    items.get(j).click();
                    isElementPresent(driver, By.tagName("h1"));
                }
            }
        }
    }