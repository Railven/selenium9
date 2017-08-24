import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class TestOppeningLinksInNewWindow extends BaseTest {

    public void testOpenningLinksInNewWindow() {
        openAdminPage();
        driver.findElement(By.cssSelector(
                "[href='http://localhost/litecart/admin/?app=countries&doc=countries']")).click();
        driver.findElement(By.cssSelector("form a")).click();
        List <WebElement> links = driver.findElements(By.cssSelector("form td i"));
        for (int i = 0; i < links.size()-1; i++) {
            links = driver.findElements(By.cssSelector("form td i"));
            links.get(i).click();
        }

    }
}
