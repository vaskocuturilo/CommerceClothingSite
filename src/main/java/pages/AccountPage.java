package pages;

import model.User;
import org.junit.Assert;
import org.openqa.selenium.By;
import waiter.WaitCondition;

import static utils.JsonData.getJsonData;

public class AccountPage {

    private static final By ACCOUNT = By.cssSelector("a[class='account']");

    private static final By SIGN_OUT_BUTTON = By.cssSelector("a[class='logout']");

    public AccountPage checkFullNameUser() {
        WaitCondition waitCondition = new WaitCondition();

        User user = getJsonData("account", User.class, "account");
        Assert.assertEquals(waitCondition.waitForVisibilityOfElementLocatedBy(ACCOUNT).getText(), user.getFullName());

        return this;
    }

    public AccountPage clickSignOutButton() {
        WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(SIGN_OUT_BUTTON).isDisplayed();
        waitCondition.waitForVisibilityOfElementLocatedBy(SIGN_OUT_BUTTON).click();

        return this;
    }
}
