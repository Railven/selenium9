import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleTest {

    private WebDriver driver;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void simpleTest() {
    driver.get("https://github.com/");
    driver.findElement(By.className("header-search-input"));
    }

    @AfterTest
    public void finish() {
        driver.quit();
        driver = null;
    }
}
