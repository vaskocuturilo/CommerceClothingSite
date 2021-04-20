package sanity;

import base.BaseClass;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LandingPage;

public class SimpleHistoryOrdersTest extends BaseClass {

    @Description("This is simple orders history automation script.")
    @Feature("Sanity.")
    @Story("This automation script check how to work orders history functional on the main page.")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Simple orders history automation script.")
    @Test
    public void simpleHistoryOrdersTest() {
        new LandingPage()
                .openAuthenticationPage()
                .enterCredentialUser()
                .selectCategory("My Orders")
                .checkThatOrdersHistoryNotEmpty()
                .clickSignOutButton();
    }
}
