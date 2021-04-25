package pages;

import io.qameta.allure.Step;
import model.Register;
import model.User;
import org.junit.Assert;
import org.openqa.selenium.By;
import waiter.WaitCondition;

import static utils.JsonData.getJsonData;

public class AccountPage extends AbstractPages {

    private static final By ACCOUNT = By.cssSelector("a[class='account']");

    private static final By SIGN_OUT_BUTTON = By.cssSelector("a[class='logout']");

    private static final By CONTACT_US_LINK = By.cssSelector("div[id='contact-link']");

    @Step
    public AccountPage checkFullNameUser() {
        final WaitCondition waitCondition = new WaitCondition();

        final User user = getJsonData("account", User.class, "account");
        Assert.assertTrue(waitCondition.waitForVisibilityOfElementLocatedBy(ACCOUNT).getText().contains(user.getFullName()));

        return this;
    }

    @Step
    public AccountPage checkFullNameForNewUser() {
        final WaitCondition waitCondition = new WaitCondition();

        final Register register = getJsonData("register", Register.class, "register");
        Assert.assertTrue(waitCondition.waitForVisibilityOfElementLocatedBy(ACCOUNT).getText().contains(register.getLastName()));

        return this;
    }

    @Step
    public AccountPage clickSignOutButton() {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(SIGN_OUT_BUTTON).isDisplayed();
        waitCondition.waitForVisibilityOfElementLocatedBy(SIGN_OUT_BUTTON).click();

        return this;
    }

    @Step
    public ContactUsPage openContactUsForm() {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(CONTACT_US_LINK).click();

        return new ContactUsPage();
    }

    @Step
    public StorePage selectCategory(final String nameLink) {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(By.cssSelector("a[title='" + nameLink + "']")).click();

        return new StorePage();
    }
}
