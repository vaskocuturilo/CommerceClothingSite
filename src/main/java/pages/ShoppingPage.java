package pages;

import base.DriverHolder;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import waiter.WaitCondition;

public class ShoppingPage {

    private static final By PROCEED_CHECKOUT = By.cssSelector("a[class*='standard-checkout button-medium']");

    private static final By PROCEED_ADDRESS = By.cssSelector("button[name='processAddress']");

    private static final By PROCEED_CARRIER = By.cssSelector("button[name='processCarrier']");

    private static final By AGREE_CHECKED = By.cssSelector("input[id='cgv']");

    private static final By CONFIRM_BUTTON = By.cssSelector("p[id='cart_navigation'] button[type='submit']");

    @Step
    public ShoppingPage completeOrder() {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(PROCEED_CHECKOUT).isDisplayed();
        waitCondition.waitForVisibilityOfElementLocatedBy(PROCEED_CHECKOUT).click();

        waitCondition.waitForVisibilityOfElementLocatedBy(PROCEED_ADDRESS).isDisplayed();
        waitCondition.waitForVisibilityOfElementLocatedBy(PROCEED_ADDRESS).click();

        waitCondition.waitForVisibilityOfElementLocatedBy(PROCEED_CARRIER).isDisplayed();
        waitCondition.waitForVisibilityOfElementLocatedBy(PROCEED_CARRIER).click();

        selectAgree();

        return new ShoppingPage();
    }

    private ShoppingPage selectAgree() {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(AGREE_CHECKED).isDisplayed();
        waitCondition.waitForVisibilityOfElementLocatedBy(AGREE_CHECKED).click();
        return this;
    }

    @Step
    public ShoppingPage paymentPurchases(final PayMethod payMethod) {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(By.cssSelector(payMethod.getPayMethod())).click();

        return this;
    }

    @Step
    public ShoppingPage confirmOrder() {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(CONFIRM_BUTTON).click();

        return this;
    }

    @Step
    public AccountPage checkThatOrderSuccess() {
        Assert.assertTrue(DriverHolder.getDriverThread().getCurrentUrl().contains("controller=order-confirmation"));

        return new AccountPage();
    }
}
