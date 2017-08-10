import org.openqa.selenium.*;
import org.testng.annotations.Test;
import java.util.Random;

@Test
public class TestNewCustomerRegistration extends BaseTest{
    public void testNewCustomerRegistration() {
        openMainPage();
        driver.findElement(By.cssSelector("[href='http://localhost/litecart/en/create_account']")).click();
        driver.findElement(By.cssSelector("[name='tax_id']")).sendKeys("tax");
        Random rand = new Random();
        String  n = Integer.toString(rand.nextInt(500) + 1);
        String email = "railvenmilva+" + n + "@gmail.com";
        driver.findElement(By.cssSelector("[name='company']")).sendKeys("company");
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("Ivan");
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("Ivanov");
        driver.findElement(By.cssSelector("[name='address1']")).sendKeys("Adress");
        driver.findElement(By.cssSelector("[name='postcode']")).sendKeys("123456");
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("Ivan");
        driver.findElement(By.cssSelector("[name='city']")).sendKeys("Washington");
        WebElement country = driver.findElement(By.cssSelector(".select2-selection__rendered"));
        country.click();
        driver.findElement(By.cssSelector(".select2-search__field")).sendKeys("United States");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("[name='phone']")).sendKeys("123456");
        String password = "12345";
        driver.findElement(By.cssSelector("[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("[name='confirmed_password']")).sendKeys(password);
        driver.findElement(By.cssSelector("[name='create_account']")).click();
        driver.findElement(By.cssSelector("[href='http://localhost/litecart/en/logout']")).click();
        WebElement loginBox = driver.findElement(By.cssSelector("#box-account-login"));
        loginBox.findElement(By.cssSelector("[name='email']")).sendKeys(email);
        loginBox.findElement(By.cssSelector("[name='password']")).sendKeys(password);
        loginBox.findElement(By.cssSelector("[name='login']")).click();
        driver.findElement(By.cssSelector("[href='http://localhost/litecart/en/logout']")).click();
    }
}
