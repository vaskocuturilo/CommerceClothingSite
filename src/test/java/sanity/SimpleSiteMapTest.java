package sanity;

import base.BaseClass;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LandingPage;

public class SimpleSiteMapTest extends BaseClass {

    @Description("This is simple site map automation script.")
    @Feature("Sanity.")
    @Story("This automation script check how to work site map functional on the main page.")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Simple contact us automation script.")
    @Test
    public void simpleSiteMapTest() {
        new LandingPage()
                .openAuthenticationPage()
                .enterCredentialUser()
                .selectLinkFromFooter("Sitemap")
                .checkThatSiteMapFunctionalWorkDone()
                .clickSignOutButton();
    }
}
