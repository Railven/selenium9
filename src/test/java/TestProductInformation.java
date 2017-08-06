import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.testng.Assert;

public class TestProductInformation extends BaseTest {
    @Test
    public void testMenuHeaders() {
        openMainPage();
        WebElement campaignsBlock = driver.findElement(By.id("box-campaigns"));
        WebElement product = campaignsBlock.findElement(By.cssSelector(".product"));
        String productNameOnMainPage = product.findElement(By.cssSelector(".name")).getAttribute("innerText");
        WebElement regularPriceOnMainPageSelector = product.findElement(By.cssSelector(".regular-price"));
        String regularPriceOnMainPage = regularPriceOnMainPageSelector.getAttribute("innerText");
        String regularPriceTag = regularPriceOnMainPageSelector.getTagName();
        String regularPriceColorOnMain = regularPriceOnMainPageSelector.getCssValue("color");
        Dimension regularPriceSizeOnMain = regularPriceOnMainPageSelector.getSize();

        Assert.assertEquals(regularPriceTag, "s", "Обычная цена товара не зачеркнута");
        Assert.assertEquals(regularPriceColorOnMain,
                "rgba(119, 119, 119, 1)",
                "Цвет цены отличен от ожидаемого" );

        WebElement campaignPriceOnMainPageSelector = product.findElement(By.cssSelector(".campaign-price"));
        String campaignPriceOnMainPage = campaignPriceOnMainPageSelector.getAttribute("innerText");
        String campaignPriceTag = campaignPriceOnMainPageSelector.getTagName();
        String campaignPriceColorOnMain = campaignPriceOnMainPageSelector.getCssValue("color");
        Dimension campaignPriceSizeOnMain = campaignPriceOnMainPageSelector.getSize();

        Assert.assertEquals(campaignPriceTag, "strong", "Акционная цена не выделена жирным");
        Assert.assertEquals(campaignPriceColorOnMain,
                "rgba(204, 0, 0, 1)",
                "Цвет цены отличен от ожидаемого" );

        Integer regularHeight = regularPriceSizeOnMain.getHeight();
        Integer regularWidth = regularPriceSizeOnMain.getWidth();
        Integer campaignHeight = campaignPriceSizeOnMain.getHeight();
        Integer campaignWidth = campaignPriceSizeOnMain.getWidth();

        Assert.assertEquals(
                regularHeight.compareTo(campaignHeight),
                -1,
                "Высота обычной цены больше акционной"
        );

        Assert.assertEquals(
                regularWidth.compareTo(campaignWidth),
                -1,
                "Ширина обычной цены больше акционной"
        );

        product.click();

        String productPageTitle = driver.findElement(By.tagName("h1")).getAttribute("innerText");
        Assert.assertEquals(
                productPageTitle,
                productNameOnMainPage,
                "Названия продукта на главной и странице продукта не совпали"
        );
        WebElement productInfo = driver.findElement(By.cssSelector(".information"));
        WebElement regularPriceOnProductPageSelector = productInfo.findElement(By.cssSelector(".regular-price"));
        String regularPriceOnProductPage = regularPriceOnProductPageSelector.getAttribute("innerText");

        Assert.assertEquals(
                regularPriceOnMainPage,
                regularPriceOnProductPage,
                "Обычная цена товара на главной и странице товара не совпали"
        );

        WebElement campaignPriceOnProductPageSelector = productInfo.findElement(By.cssSelector(".campaign-price"));
        String campaignPriceOnProductPage = campaignPriceOnProductPageSelector.getAttribute("innerText");

        Assert.assertEquals(
                campaignPriceOnMainPage,
                campaignPriceOnProductPage,
                "Обычная цена товара на главной и странице товара не совпали"
        );

        String regularPriceTagProduct = regularPriceOnProductPageSelector.getTagName();
        String regularPriceColorProduct = regularPriceOnProductPageSelector.getCssValue("color");
        Dimension regularPriceSizeProduct = regularPriceOnProductPageSelector.getSize();

        Assert.assertEquals(regularPriceTagProduct, "s", "Обычная цена товара не зачеркнута");
        Assert.assertEquals(regularPriceColorProduct,
                "rgba(102, 102, 102, 1)",
                "Цвет цены отличен от ожидаемого" );

        String campaignPriceTagProduct = campaignPriceOnProductPageSelector.getTagName();
        String campaignPriceColorProduct = campaignPriceOnProductPageSelector.getCssValue("color");
        Dimension campaignPriceSizeProduct = campaignPriceOnProductPageSelector.getSize();

        Assert.assertEquals(campaignPriceTagProduct, "strong", "Акционная цена не выделена жирным");
        Assert.assertEquals(campaignPriceColorProduct,
                "rgba(204, 0, 0, 1)",
                "Цвет цены отличен от ожидаемого" );

        Integer regularHeightProduct = regularPriceSizeProduct.getHeight();
        Integer regularWidthProduct = regularPriceSizeProduct.getWidth();
        Integer campaignHeightProduct = campaignPriceSizeProduct.getHeight();
        Integer campaignWidthProduct = campaignPriceSizeProduct.getWidth();

        Assert.assertEquals(
                regularHeightProduct.compareTo(campaignHeightProduct),
                -1,
                "Высота обычной цены больше акционной"
        );

        Assert.assertEquals(
                regularWidthProduct.compareTo(campaignWidthProduct),
                -1,
                "Ширина обычной цены больше акционной"
        );
    }
}
