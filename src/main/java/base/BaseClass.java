package base;

import browsers.Chrome;
import data.UserInformation;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ScreenShotOnFailure;

import java.util.concurrent.TimeUnit;

import static pages.AbstractPages.*;
import static webconfig.WebConfig.BASE_CONFIG;

public class BaseClass {

    private static final int DELAY = 10;

    @Rule
    public ScreenShotOnFailure onFailure = new ScreenShotOnFailure();

    @Before
    public void createData() {
        UserInformation userInformation = new UserInformation();
        userInformation.createJsonFileWithUserInformation();
    }

    @BeforeClass
    public static void start() {
        final DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
        final Chrome chrome = new Chrome();
        DriverHolder.setDriverThread(chrome.createDriver(capabilities));
        DriverHolder.getDriverThread().manage().timeouts().implicitlyWait(DELAY, TimeUnit.SECONDS);
        DriverHolder.getDriverThread().manage().timeouts().pageLoadTimeout(DELAY, TimeUnit.SECONDS);
        DriverHolder.getDriverThread().manage().timeouts().setScriptTimeout(DELAY, TimeUnit.SECONDS);
        navigateWebBrowser().to(BASE_CONFIG.getWebUrl());
    }

    @AfterClass
    public static void stop() {
        clearLocalStorage();
        closeWebBrowser();
    }
}
