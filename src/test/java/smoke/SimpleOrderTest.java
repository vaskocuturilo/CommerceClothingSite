package smoke;

import base.BaseClass;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LandingPage;
import pages.PayMethod;

public class SimpleOrderTest extends BaseClass {

    @Description("This is simply to create an order automation script.")
    @Feature("Smoke.")
    @Story("This automation script checks create order on the store page.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Simple create order automation script.")
    @Test
    public void simpleOrderTest() {
        new LandingPage()
                .openAuthenticationPage()
                .enterCredentialUser()
                .selectCategory("Women")
                .selectFirstProductFromList()
                .proceedToCheckoutStage()
                .completeOrder()
                .paymentPurchases(PayMethod.BANK_WIRE)
                .confirmOrder()
                .checkThatOrderSuccess()
                .clickSignOutButton();
    }
}
