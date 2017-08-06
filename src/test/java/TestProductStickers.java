import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class TestProductStickers extends BaseTest {
    @Test
    public void testMenuHeaders() {
        openMainPage();
        List<WebElement> products = driver.findElements(By.className("product"));
        for (int i = 0; i < products.size(); i++ ) {
            products = driver.findElements(By.className("product"));
            List<WebElement> stickers = products.get(i).findElements(By.className("sticker"));
            Assert.assertNotNull(stickers, "У данного товара стикер отсутствует");
            Assert.assertEquals(
                    stickers.size(),
                    1,
                    "Количество стикеров у товара не равно 1"
            );
        }
    }
}
