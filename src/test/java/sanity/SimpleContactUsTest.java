package sanity;

import base.BaseClass;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LandingPage;

public class SimpleContactUsTest extends BaseClass {

    @Description("This is simple contact us automation script.")
    @Feature("Sanity.")
    @Story("This automation script check how to work contact us functional on the main page.")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Simple contact us automation script.")
    @Test
    public void simpleContactUsTest() {
        new LandingPage()
                .openAuthenticationPage()
                .enterCredentialUser()
                .openContactUsForm()
                .fillingContactUsData()
                .clickSendButton()
                .checkThatSendMessageIsSuccess();
    }
}
