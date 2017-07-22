import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginScenarioTest {

    private WebDriver driver;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void simpleTest() {
        driver.get("http://localhost/litecart/admin/login.php");
        String LogAndPass = "admin";
        driver.findElement(By.name("username")).sendKeys(LogAndPass);
        driver.findElement(By.name("password")).sendKeys(LogAndPass);
        driver.findElement(By.name("login")).click();
    }

    @AfterTest
    public void finish() {
        driver.quit();
        driver = null;
    }
}


