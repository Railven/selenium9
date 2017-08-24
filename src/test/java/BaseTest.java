import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    //public WebDriverWait wait;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
    }

    boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    protected void openAdminPage() {
        driver.get("http://localhost/litecart/admin/login.php");
        String LogAndPass = "admin";
        driver.findElement(By.name("username")).sendKeys(LogAndPass);
        driver.findElement(By.name("password")).sendKeys(LogAndPass);
        WebElement element = driver.findElement(By.name("login"));
        element.click();
    }

    protected void openMainPage() {
        driver.get("http://localhost/litecart/");
    }

    @AfterTest
    public void finish() {
        driver.quit();
        driver = null;
    }
}
