package smoke;

import base.BaseClass;
import org.junit.Test;
import pages.MainPage;

public class SimpleSearchTest extends BaseClass {

    private static final String SEARCH_TEXT = "Dress";

    @Test
    public void simpleSearchTest() {
        MainPage mainPage = new MainPage();
        mainPage.enterInformationForSearch(SEARCH_TEXT)
                .checkSearchResult(SEARCH_TEXT)
                .checkThatSearchResultNotNull();
    }
}
