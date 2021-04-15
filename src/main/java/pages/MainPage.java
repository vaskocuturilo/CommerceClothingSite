package pages;

import base.DriverHolder;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import waiter.WaitCondition;

public class MainPage {

    private static final String TITLE = "My Store";

    private static final By QUERY_SEARCH = By.cssSelector("input[id='search_query_top']");

    private static final By SEARCH_BUTTON = By.cssSelector("button[name='submit_search']");

    @Step
    public MainPage checkThatMainPageLoad() {
        Assert.assertEquals(DriverHolder.getDriverThread().getTitle(), TITLE);
        return this;
    }

    public SearchPage enterInformationForSearch(final String query) {
        WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(QUERY_SEARCH).clear();
        waitCondition.waitForVisibilityOfElementLocatedBy(QUERY_SEARCH).sendKeys(query);
        waitCondition.waitForVisibilityOfElementLocatedBy(SEARCH_BUTTON).click();

        return new SearchPage();
    }
}
