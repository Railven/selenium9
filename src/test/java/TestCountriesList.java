import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class TestCountriesList extends BaseTest {

    @Test
    public void testCountriesList() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        openAdminPage();
        List<WebElement> menuItems = driver.findElements(By.cssSelector("span.name"));
        for (int i = 0; i < menuItems.size()-1; i++) {
            String text = menuItems.get(i).getAttribute("innerHTML");
            if (text.equals("Countries")) {
                menuItems.get(i).click();
                break;
            }
        }
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> zoneList = new ArrayList<>();
        WebElement table = driver.findElement(By.cssSelector(".dataTable"));
        List<WebElement> rows = table.findElements(By.cssSelector("tr.row"));
        for (int i = 0; i < rows.size()-1; i++) {
            WebElement tableWait = wait.until(presenceOfElementLocated(By.cssSelector(".dataTable")));
            table = driver.findElement(By.cssSelector(".dataTable"));
            rows = table.findElements(By.cssSelector("tr.row"));
            List<WebElement> cells = rows.get(i).findElements(By.cssSelector("td"));
            WebElement countryNameLink = cells.get(4).findElement(By.tagName("a"));
            String countryName = cells.get(4).findElement(By.tagName("a")).getAttribute("innerHTML");
            String zoneCountStr = cells.get(5).getAttribute("innerText");
            int zoneCount = Integer.parseInt(zoneCountStr);
            if (zoneCount > 0) {
                countryNameLink.click();
                WebElement zonesTable = driver.findElement(By.cssSelector("#table-zones"));
                List<WebElement> zoneRows = zonesTable.findElements(By.cssSelector("tr"));
                for (WebElement zoneRow : zoneRows) {
                    List<WebElement> zoneCells = zoneRow.findElements(By.cssSelector("td"));
                    if (zoneCells.size() > 0) {
                        String zoneName = zoneCells.get(2).findElement(By.tagName("input")).getAttribute("value");
                        zoneList.add(zoneName);
                    }
                }
                ArrayList<String> zoneBeforeSorting = zoneList;
                Collections.sort(zoneList);
                Assert.assertEquals(zoneBeforeSorting, zoneList, "Список зон отсортирован не по алфавиту");
                driver.navigate().back();
            }
            list.add(countryName);
        }
        ArrayList<String> beforeSortingList = list;
        Collections.sort(list);
        Assert.assertEquals(beforeSortingList, list, "Список стран отсортирован не по алфавиту");
    }

    @Test
    public void testGeoZones() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        openAdminPage();
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        WebElement table = driver.findElement(By.cssSelector(".dataTable"));
        List<WebElement> rows = table.findElements(By.cssSelector("tr"));
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < rows.size()-1; i++) {
            WebElement tableWait = wait.until(presenceOfElementLocated(By.cssSelector(".dataTable")));
            table = driver.findElement(By.cssSelector(".dataTable"));
            rows = table.findElements(By.cssSelector("tr"));
            List<WebElement> cells = rows.get(i).findElements(By.cssSelector("td"));
            WebElement countryNameLink = cells.get(2).findElement(By.tagName("a"));
            countryNameLink.click();
            WebElement zonesTable = driver.findElement(By.cssSelector("#table-zones"));
            List<WebElement> zoneRows = zonesTable.findElements(By.cssSelector("tr"));
            for (int j = 1; j < zoneRows.size()-1; j++) {
                List<WebElement> zoneCells = zoneRows.get(j).findElements(By.cssSelector("td"));
                String zoneName = zoneCells.get(2).findElement(By.cssSelector("option[selected='selected']")).getAttribute("innerText");
                list.add(zoneName);
            }
            ArrayList<String> beforeSortingList = list;
            Collections.sort(list);
            Assert.assertEquals(beforeSortingList, list, "Список стран отсортирован не по алфавиту");
            list.clear();
            beforeSortingList.clear();
            driver.navigate().back();
        }
    }
}