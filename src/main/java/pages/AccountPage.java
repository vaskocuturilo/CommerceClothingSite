package pages;

import model.User;
import org.junit.Assert;
import org.openqa.selenium.By;
import waiter.WaitCondition;

import static utils.JsonData.getJsonData;

public class AccountPage extends AbstractPages {

    private static final By ACCOUNT = By.cssSelector("a[class='account']");

    private static final By SIGN_OUT_BUTTON = By.cssSelector("a[class='logout']");

    private static final By CONTACT_US_LINK = By.cssSelector("div[id='contact-link']");


    public AccountPage checkFullNameUser() {
        final WaitCondition waitCondition = new WaitCondition();

        final User user = getJsonData("account", User.class, "account");
        Assert.assertEquals(waitCondition.waitForVisibilityOfElementLocatedBy(ACCOUNT).getText(), user.getFullName());

        return this;
    }

    public AccountPage clickSignOutButton() {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(SIGN_OUT_BUTTON).isDisplayed();
        waitCondition.waitForVisibilityOfElementLocatedBy(SIGN_OUT_BUTTON).click();

        return this;
    }

    public ContactUsPage openContactUsForm() {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(CONTACT_US_LINK).click();

        return new ContactUsPage();
    }

    public StorePage selectCategory(final String nameLink) {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(By.cssSelector("a[title='" + nameLink + "']")).click();

        return new StorePage();
    }


}
