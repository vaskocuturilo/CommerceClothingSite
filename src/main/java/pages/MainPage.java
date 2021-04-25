package pages;

import base.DriverHolder;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import waiter.WaitCondition;

import static utils.EmailUtil.createEmailForNewUser;

public class MainPage extends AbstractPages {

    private static final String TITLE = "My Store";

    private static final By QUERY_SEARCH = By.cssSelector("input[id='search_query_top']");

    private static final By SEARCH_BUTTON = By.cssSelector("button[name='submit_search']");

    private static final By NEWSLETTER_INPUT = By.cssSelector("input[id='newsletter-input']");

    private static final By NEWSLETTER_SUBMIT = By.cssSelector("button[name='submitNewsletter']");

    private static final By ALERT_SUCCESS = By.cssSelector("p[class='alert alert-success']");

    private static final String GREEN_COLOR = "rgba(85, 198, 94, 1)";

    @Step
    public MainPage checkThatMainPageLoad() {
        Assert.assertEquals(DriverHolder.getDriverThread().getTitle(), TITLE);
        return this;
    }

    @Step
    public SearchPage enterInformationForSearch(final String query) {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(QUERY_SEARCH).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(QUERY_SEARCH).sendKeys(query);
        waitCondition.waitForVisibilityOfElementLocatedBy(SEARCH_BUTTON).click();

        return new SearchPage();
    }

    @Step
    public MainPage enterEmailSubscribeNewsletter() {
        scrollDownPage();
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(NEWSLETTER_INPUT).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(NEWSLETTER_INPUT).sendKeys(createEmailForNewUser());

        return this;
    }

    @Step
    public MainPage clickSubmitButton() {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(NEWSLETTER_SUBMIT).click();

        return this;
    }

    @Step
    public MainPage checkThatSubscribeSuccess() {
        final WaitCondition waitCondition = new WaitCondition();
        Assert.assertTrue(waitCondition.waitForVisibilityOfElementLocatedBy(ALERT_SUCCESS).getCssValue("background-color").contains(GREEN_COLOR));

        return this;
    }
}
