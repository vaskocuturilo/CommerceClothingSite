package pages;

import base.DriverHolder;
import io.qameta.allure.Step;
import org.junit.Assert;

public class MainPage {

    private static final String TITLE = "My Store";

    @Step
    public MainPage checkThatMainPageLoad() {
        Assert.assertEquals(DriverHolder.getDriverThread().getTitle(), TITLE);
        return this;
    }
}
