package smoke;

import base.BaseClass;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

public class SimpleSearchTest extends BaseClass {

    private static final String SEARCH_TEXT = "Dress";

    @Description("This is simple search automation script.")
    @Feature("Smoke.")
    @Story("This automation script check how to work search functional on the main page.")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Simple search automation script.")
    @Test
    public void simpleSearchTest() {
        MainPage mainPage = new MainPage();
        mainPage.enterInformationForSearch(SEARCH_TEXT)
                .checkSearchResult(SEARCH_TEXT)
                .checkThatSearchResultNotNull();
    }
}
