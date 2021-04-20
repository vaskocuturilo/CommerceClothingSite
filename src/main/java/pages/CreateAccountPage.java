package pages;

import base.DriverHolder;
import io.qameta.allure.Step;
import model.Register;
import model.User;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import waiter.WaitCondition;

import static utils.JsonData.getJsonData;

public class CreateAccountPage {

    private static final By FIRST_NAME = By.cssSelector("input[id='customer_firstname']");

    private static final By LAST_NAME = By.cssSelector("input[id='customer_lastname']");

    private static final By PASSWORD = By.cssSelector("input[id='passwd']");

    private static final By ADDRESS = By.cssSelector("input[id='address1']");

    private static final By CITY = By.cssSelector("input[id='city']");

    private static final By PHONE = By.cssSelector("input[id='phone_mobile']");

    private static final By ZIP_CODE = By.cssSelector("input[id='postcode']");

    private static final By REGISTER_BUTTON = By.cssSelector("button[id='submitAccount']");

    private static final By DISABLED_BUTTON = By.cssSelector("div[class='btn--order-submit.disabled']");

    @Step
    public CreateAccountPage fillingDataNewUser() {
        selectGenderType(Gender.MR);
        enterCredentialNewUser();
        selectStateByName();
        clickRegisterButton();

        return this;
    }

    @Step
    public AccountPage checkThatCreateNewUserSuccess() {
        WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForInvisibilityOfElementLocated(DISABLED_BUTTON);
        Assert.assertTrue(DriverHolder.getDriverThread().getCurrentUrl().contains("controller=my-account"));

        return new AccountPage();
    }

    private CreateAccountPage selectGenderType(final Gender gender) {
        WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(By.cssSelector(gender.getGender())).click();

        return this;
    }

    private CreateAccountPage selectStateByName() {
        Register register = getJsonData("register", Register.class, "register");
        Select select = new Select(DriverHolder.getDriverThread().findElement(By.cssSelector("select[id='id_state']")));
        select.selectByVisibleText(register.getState());

        return this;
    }

    private CreateAccountPage enterCredentialNewUser() {
        WaitCondition waitCondition = new WaitCondition();
        Register register = getJsonData("register", Register.class, "register");

        waitCondition.waitForVisibilityOfElementLocatedBy(FIRST_NAME).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(FIRST_NAME).sendKeys(register.getFirstName());

        waitCondition.waitForVisibilityOfElementLocatedBy(LAST_NAME).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(LAST_NAME).sendKeys(register.getLastName());

        waitCondition.waitForVisibilityOfElementLocatedBy(PASSWORD).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(PASSWORD).sendKeys(register.getPassword());

        waitCondition.waitForVisibilityOfElementLocatedBy(ADDRESS).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(ADDRESS).sendKeys(register.getAddress());

        waitCondition.waitForVisibilityOfElementLocatedBy(CITY).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(CITY).sendKeys(register.getCity());

        waitCondition.waitForVisibilityOfElementLocatedBy(ZIP_CODE).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(ZIP_CODE).sendKeys(register.getZipCode());

        waitCondition.waitForVisibilityOfElementLocatedBy(PHONE).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(PHONE).sendKeys(register.getPhone());

        return this;
    }

    private CreateAccountPage clickRegisterButton() {
        WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(REGISTER_BUTTON).isDisplayed();
        waitCondition.waitForVisibilityOfElementLocatedBy(REGISTER_BUTTON).click();
        return this;
    }
}
