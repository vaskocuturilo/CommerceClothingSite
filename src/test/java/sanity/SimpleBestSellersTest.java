package sanity;

import base.BaseClass;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LandingPage;
import pages.OrderWay;
import pages.SortBy;

public class SimpleBestSellersTest extends BaseClass {

    @Description("This is simple best sellers automation script.")
    @Feature("Sanity.")
    @Story("This automation script check how to work best sellers functional on the main page.")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Simple best sellers automation script.")
    @Test
    public void simpleBestSellersTest() {
        new LandingPage()
                .openAuthenticationPage()
                .enterCredentialUser()
                .selectCategory("Best sellers")
                .selectSortBy(SortBy.LOWEST)
                .checkThatSelectLowerPriceSeller(OrderWay.LOWEST)
                .clickSignOutButton();
    }
}
