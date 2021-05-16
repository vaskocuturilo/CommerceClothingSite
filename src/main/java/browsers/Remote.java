package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public class Remote implements WebDriverProvider {

    private static final Logger LOGGER = Logger.getLogger(Remote.class.getName());

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setBrowserName("");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, Chrome.getChromeOptions());
        capabilities.setCapability("screenResolution", "1920x1080x24");

        try {
            return new RemoteWebDriver(getGridHubUrl(), capabilities);
        } catch (RuntimeException exception) {
            LOGGER.info("he method createDriver is down.");
            throw new WebDriverException("The method createDriver is down. ", exception);
        }
    }

    private static URL getGridHubUrl() {
        URL hostURL = null;
        try {
            hostURL = new URL(System.getProperty("http://localhost:4444/wd/hub", "http://localhost:4444/wd/hub"));
        } catch (MalformedURLException ex) {
            LOGGER.info("hostURL" + ex);
        }
        return hostURL;
    }

}
