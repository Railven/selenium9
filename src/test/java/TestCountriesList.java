import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCountriesList extends BaseTest {

    @Test
    public void testCountriesList() {
        openAdminPage();
        List<WebElement> menuItems = driver.findElements(By.cssSelector("span.name"));
        for (int i = 0; i < menuItems.size(); i++) {
            String text = menuItems.get(i).getAttribute("innerHTML");
            if (text.equals("Countries")) {
                menuItems.get(i).click();
                break;
            }
        }
        ArrayList<String> list = new ArrayList<>();
        WebElement table = driver.findElement(By.cssSelector(".dataTable"));
        List<WebElement> rows = table.findElements(By.cssSelector("tr.row"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector("td"));
            String countryName = cells.get(4).findElement(By.tagName("a")).getAttribute("innerHTML");
            list.add(countryName);
        }
        ArrayList<String> beforeSortingList = list;
        Collections.sort(list);
        Assert.assertEquals(beforeSortingList, list, "Список стран отсортирован не по алфавиту");
    }
}