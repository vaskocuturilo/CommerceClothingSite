package pages;

import base.DriverHolder;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import waiter.WaitCondition;

import java.util.Arrays;
import java.util.List;

public class StorePage {

    private static final By CATEGORY_LIST = By.cssSelector("div[id='center_column'] h3");

    private static final By PRODUCT_LIST = By.cssSelector("ul[class='product_list grid row'] img");

    private static final By ADD_CART = By.cssSelector("form[id='buy_block'] p[id='add_to_cart']");

    private static final By PROCEED_BUTTON = By.cssSelector("div[class='button-container'] a");

    public AccountPage checkThatSiteMapFunctionalWorkDone() {
        final List<String> notAllEqualList = Arrays.asList("Our offers", "Your Account", "Categories", "Pages");
        final List<WebElement> elementList = DriverHolder.getDriverThread().findElements(CATEGORY_LIST);
        Assert.assertTrue(!elementList.isEmpty());

        Assert.assertTrue(elementList.size() == 4);

        for (int i = 0; i < elementList.toArray().length; i++) {
            final String textActual = elementList.get(i).getText();
            final String textExpected = notAllEqualList.get(i).toUpperCase();
            Assert.assertEquals(textActual, textExpected);
        }
        return new AccountPage();
    }

    public StorePage selectFirstProductFromList() {
        final WaitCondition waitCondition = new WaitCondition();
        final List<WebElement> elementList = DriverHolder.getDriverThread().findElements(PRODUCT_LIST);
        elementList.stream().findFirst().get().click();

        waitCondition.waitForVisibilityOfElementLocatedBy(ADD_CART).isDisplayed();
        waitCondition.waitForVisibilityOfElementLocatedBy(ADD_CART).click();

        return this;
    }

    public ShoppingPage proceedToCheckoutStage() {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(PROCEED_BUTTON).isDisplayed();
        waitCondition.waitForVisibilityOfElementLocatedBy(PROCEED_BUTTON).click();

        return new ShoppingPage();
    }
}
