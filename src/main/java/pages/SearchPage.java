package pages;

import base.DriverHolder;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import waiter.WaitCondition;

import java.util.List;
import java.util.Locale;

public class SearchPage {

    private static final By SEARCH_FIELD = By.cssSelector("span[class='lighter']");

    private static final By LIST_PRODUCTS = By.cssSelector("ul[class='product_list grid row'] div[class='product-image-container']");

    public SearchPage checkSearchResult(final String result) {
        final WaitCondition waitCondition = new WaitCondition();
        final String parseString = waitCondition.waitForVisibilityOfElementLocatedBy(SEARCH_FIELD).getText().replaceAll("^\\\"+|\\\"+$", "");
        Assert.assertEquals(parseString, result.toUpperCase(Locale.US));

        return this;
    }

    public SearchPage checkThatSearchResultNotNull() {
        final List<WebElement> webElementList = DriverHolder.getDriverThread().findElements(LIST_PRODUCTS);
        Assert.assertTrue(!webElementList.isEmpty());

        return this;
    }
}
