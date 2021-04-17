package smoke;

import base.BaseClass;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LandingPage;

public class SimpleAuthorizationTest extends BaseClass {

    @Description("This is simple login automation script.")
    @Feature("Smoke.")
    @Story("This automation script check authentication functional on the authorization page.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Simple login automation script.")
    @Test
    public void simpleAuthorizationTest() {
        new LandingPage()
                .openAuthenticationPage()
                .enterCredentialUser()
                .checkFullNameUser()
                .clickSignOutButton();
    }
}
