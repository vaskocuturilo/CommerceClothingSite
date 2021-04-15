package base;

import browsers.Chrome;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static pages.AbstractPages.*;

public class BaseClass {

    private static final int DELAY = 10;

    @BeforeClass
    public static void start() {
        final DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
        final Chrome chrome = new Chrome();
        DriverHolder.setDriverThread(chrome.createDriver(capabilities));
        DriverHolder.getDriverThread().manage().timeouts().implicitlyWait(DELAY, TimeUnit.SECONDS);
        DriverHolder.getDriverThread().manage().timeouts().pageLoadTimeout(DELAY, TimeUnit.SECONDS);
        DriverHolder.getDriverThread().manage().timeouts().setScriptTimeout(DELAY, TimeUnit.SECONDS);
        navigateWebBrowser().to("http://automationpractice.com/index.php");
    }

    @AfterClass
    public static void stop() {
        clearLocalStorage();
        closeWebBrowser();
    }
}
