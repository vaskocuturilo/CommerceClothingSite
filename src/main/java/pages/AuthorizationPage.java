package pages;

import io.qameta.allure.Step;
import model.User;
import org.openqa.selenium.By;
import waiter.WaitCondition;

import static utils.EmailUtil.createEmailForNewUser;
import static utils.JsonData.getJsonData;

public class AuthorizationPage extends AbstractPages {

    private static final By LOGIN_FORM = By.cssSelector("form[id='login_form']");

    private static final By EMAIL_FIELD = By.cssSelector("input[id='email']");

    private static final By PASSWORD_FIELD = By.cssSelector("input[id='passwd']");

    private static final By SIGN_IN_BUTTON = By.cssSelector("button[id='SubmitLogin']");

    private static final By INPUT_EMAIL = By.cssSelector("input[id='email_create']");

    private static final By CREATE_ACCOUNT_BUTTON = By.cssSelector("button[id='SubmitCreate']");

    @Step
    public AccountPage enterCredentialUser() {
        checkThatLoginFormAvailable();
        enterUserEmail();
        enterPassword();
        clickSignInButton();
        return new AccountPage();
    }

    @Step
    public CreateAccountPage enterEmailForNewUser() {
        WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(INPUT_EMAIL).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(INPUT_EMAIL).sendKeys(createEmailForNewUser());
        waitCondition.waitForVisibilityOfElementLocatedBy(CREATE_ACCOUNT_BUTTON).click();

        return new CreateAccountPage();
    }

    private AuthorizationPage checkThatLoginFormAvailable() {
        WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(LOGIN_FORM).isDisplayed();

        return this;
    }

    private AuthorizationPage enterUserEmail() {
        WaitCondition waitCondition = new WaitCondition();
        User user = getJsonData("account", User.class, "account");

        waitCondition.waitForVisibilityOfElementLocatedBy(EMAIL_FIELD).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(EMAIL_FIELD).sendKeys(user.getEmail());

        return this;
    }

    private AuthorizationPage enterPassword() {
        WaitCondition waitCondition = new WaitCondition();
        User user = getJsonData("account", User.class, "account");

        waitCondition.waitForVisibilityOfElementLocatedBy(PASSWORD_FIELD).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(PASSWORD_FIELD).sendKeys(user.getPassword());

        return this;
    }

    private AuthorizationPage clickSignInButton() {
        WaitCondition waitCondition = new WaitCondition();

        waitCondition.waitForVisibilityOfElementLocatedBy(SIGN_IN_BUTTON).isDisplayed();
        waitCondition.waitForVisibilityOfElementLocatedBy(SIGN_IN_BUTTON).click();

        return this;
    }
}
