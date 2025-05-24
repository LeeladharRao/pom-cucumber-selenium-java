package com.org.keywords;

import com.org.constants.Constants;
import com.org.driver.DriverManager;
import com.org.utils.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class WebUI {

    public static void navigateToUrl(String URL) {
        try {
            sleep(Constants.WAIT_SLEEP_STEP);
        } catch (InterruptedException e) {
            LogManager.warn("Did not wait for " + Constants.WAIT_SLEEP_STEP);
        }
        DriverManager.getDriver().navigate().to(URL);
        waitForPageLoaded();

        LogManager.info("Navigated to URL: " + URL);

//        addScreenshotToReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + DateUtils.getCurrentDateTime());
    }

    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.WAIT_PAGE_LOADED));
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

        // Wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");

        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        // Wait until javascript is ready
        if (!jsReady) {
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                LogManager.error("Timeout waiting for page load. (" + Constants.WAIT_PAGE_LOADED + "s)");
                Assert.fail("Timeout waiting for page load. (" + Constants.WAIT_PAGE_LOADED + "s)");
            }
        }
    }

    public static WebElement waitForElementPresent(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.WAIT_EXPLICIT));
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Throwable error) {
            LogManager.error("Element not exist. (waitForElementPresent) " + element.toString());
            Assert.fail("Element not exist. (waitForElementPresent) " + element);
        }
        return null;
    }

    public static WebElement waitForElementClickable(WebElement element) {
        waitForElementPresent(element);
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.WAIT_EXPLICIT));
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Throwable error) {
            LogManager.error("Timeout waiting for the element ready to click. " + element.toString());
            Assert.fail("Timeout waiting for the element ready to click. " + element);
        }
        return null;
    }

    public static boolean isElementVisible(WebElement element, int second) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(second));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static void scrollToElementAtBottom(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", element);
        LogManager.info("Scroll to element " + element);
    }

    public static WebElement waitForElementVisible(WebElement element) {
        waitForElementPresent(element);
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.WAIT_EXPLICIT));

            boolean check = isElementVisible(element, 1);
            if (check) {
                return wait.until(ExpectedConditions.visibilityOf(element));
            } else {
                scrollToElementAtBottom(element);
                return wait.until(ExpectedConditions.visibilityOf(element));
            }
        } catch (Throwable error) {
            LogManager.error("Timeout waiting for the element Visible. " + element.toString());
            Assert.fail("Timeout waiting for the element Visible. " + element);
        }
        return null;
    }

    public static WebElement dynamic(By path, Object... dynamicPath) {
        if (path == null) {
            throw new IllegalArgumentException("Locator cannot be null");
        }
        String locatorString = path.toString();
        String locatorPath;
        if (locatorString.contains(": ")) {
            int separatorIndex = locatorString.indexOf(": ");
            locatorPath = locatorString.substring(separatorIndex + 2);
        } else {
            throw new IllegalArgumentException("Invalid locator format: " + locatorString);
        }

        String formattedPath = String.format(locatorPath, dynamicPath);

        return DriverManager.getDriver().findElement(By.xpath(formattedPath));
    }

    public static void clickElement(WebElement element) {
        waitForPageLoaded();
        waitForElementClickable(element).click();
        LogManager.info("Clicked on the element " + element.toString());
    }

    public static void setText(WebElement element, String value) {
        waitForPageLoaded();
        waitForElementVisible(element);
        waitForElementClickable(element);
        element.sendKeys(value);
        LogManager.info("Set text " + value + " on " + element);
    }
}
