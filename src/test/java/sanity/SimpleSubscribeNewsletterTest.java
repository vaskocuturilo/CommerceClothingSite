package sanity;

import base.BaseClass;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

public class SimpleSubscribeNewsletterTest extends BaseClass {

    @Description("This is simple subscribe newsletter automation script.")
    @Feature("Sanity.")
    @Story("This automation script check how to work subscribe newsletter functional on the main page.")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Simple subscribe newsletter automation script.")
    @Test
    public void simpleSubscribeNewsletterTest() {
        MainPage mainPage = new MainPage();
        mainPage.enterEmailSubscribeNewsletter()
                .clickSubmitButton()
                .checkThatSubscribeSuccess();
    }
}
