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

    public ContactUsPage openContactUsForm() {
        WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(CONTACT_US_LINK).click();

        return new ContactUsPage();
    }

    public StorePage selectLinkFromFooter(final String nameLink) {
        WaitCondition waitCondition = new WaitCondition();
        scrollDownPage();
        waitCondition.waitForVisibilityOfElementLocatedBy(By.cssSelector("a[title='" + nameLink + "']")).click();

        return new StorePage();
    }


}
