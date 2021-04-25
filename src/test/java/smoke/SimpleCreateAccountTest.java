package smoke;

import base.BaseClass;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LandingPage;

public class SimpleCreateAccountTest extends BaseClass {

    @Description("This is simple create a new user automation script.")
    @Feature("Smoke.")
    @Story("This automation script check create user functional on the authorization page.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Simple register automation script.")
    @Test
    public void simpleCreateAccountTest() {
        new LandingPage()
                .openAuthenticationPage()
                .enterEmailForNewUser()
                .fillingDataNewUser()
                .checkThatCreateNewUserSuccess()
                .checkFullNameForNewUser()
                .clickSignOutButton();
    }
}
