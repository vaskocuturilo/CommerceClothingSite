package pages;

import base.DriverHolder;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class StorePage {

    private static final By CATEGORY_LIST = By.cssSelector("div[id='center_column'] h3");

    public AccountPage checkThatSiteMapFunctionalWorkDone() {
        List<String> notAllEqualList = Arrays.asList("Our offers", "Your Account", "Categories", "Pages");

        List<WebElement> elementList = DriverHolder.getDriverThread().findElements(CATEGORY_LIST);
        Assert.assertTrue(!elementList.isEmpty());

        Assert.assertTrue(elementList.size() == 4);

        for (int i = 0; i < elementList.toArray().length; i++) {
            String textActual = elementList.get(i).getText();
            String textExpected = notAllEqualList.get(i).toUpperCase();
            Assert.assertEquals(textActual, textExpected);
        }
        return new AccountPage();
    }
}
