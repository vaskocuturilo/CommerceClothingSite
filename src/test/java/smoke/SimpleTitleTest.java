package smoke;

import base.BaseClass;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

public class SimpleTitleTest extends BaseClass {

    @Description("This is simple automation script.")
    @Feature("Smoke.")
    @Story("This automation script check that main page is loaded and assert title.")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Simple automation script.")
    @Test
    public void testSimple() {
        MainPage mainPage = new MainPage();
        mainPage.checkThatMainPageLoad();
    }
}
