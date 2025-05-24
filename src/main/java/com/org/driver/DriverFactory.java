package com.org.driver;

import com.org.constants.Constants;
import com.org.enums.Enums;
import com.org.utils.LogManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DriverFactory {

    public WebDriver createInstance() {
        Enums.Target target = Enums.Target.valueOf(Constants.TARGET.toUpperCase());
        WebDriver driver;

        String browser = Constants.BROWSER;

        switch (target) {
            case LOCAL:
                driver = BrowserManager.valueOf(browser.toUpperCase()).createDriver();
                break;
            case REMOTE:
                driver = createRemoteInstance(BrowserManager.valueOf(browser.toUpperCase()).getOptions());
            default:
                throw new WebDriverException(target.toString());
        }

        return driver;
    }

    public RemoteWebDriver createRemoteInstance(MutableCapabilities capabilities) {
        RemoteWebDriver remoteWebDriver = null;
        try {
            String gridURL = String.format("http://%s:%s", Constants.REMOTE_URL, Constants.REMOTE_PORT);

            remoteWebDriver = new RemoteWebDriver(new URL(gridURL), capabilities);
        } catch (java.net.MalformedURLException e) {
            LogManager.error("Grid URL is invalid or Grid Port is not available");
            LogManager.error("Browser: " + capabilities.getBrowserName() + e);
        } catch (IllegalArgumentException e) {
            LogManager.error("Browser %s is not valid or recognized " + capabilities.getBrowserName() + e);
        }

        return remoteWebDriver;
    }
}
