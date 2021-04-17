package pages;

import org.openqa.selenium.By;
import waiter.WaitCondition;

public class LandingPage {

    private static final By SIGN_IN = By.cssSelector("a[class='login']");

    public AuthorizationPage openAuthenticationPage() {
        WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(SIGN_IN).click();

        return new AuthorizationPage();
    }
}
