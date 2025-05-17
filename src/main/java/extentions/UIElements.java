package extentions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UIElements {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public UIElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public static void performEnterText(WebElement locator, String value) {
        waitUntilElementVisible(locator);
        waitUntilElementClickable(locator);
        scrollToElement(locator);
        locator.click();
        locator.clear();
        locator.sendKeys(value);
    }

    public static void performClick(WebElement locator) {
        waitUntilElementVisible(locator);
        waitUntilElementClickable(locator);
        scrollToElement(locator);
        locator.click();
    }

    public static void performDropDownSelectionByText(WebElement locator, String dropDownText) {
        waitUntilElementVisible(locator);
        scrollToElement(locator);
        var select = new Select(locator);
        select.selectByVisibleText(dropDownText);
    }

    public static void performDropDownSelectionByIndex(WebElement locator, int index) {
        waitUntilElementVisible(locator);
        scrollToElement(locator);
        var select = new Select(locator);
        select.selectByIndex(index);
    }

    public static void performDropDownSelectionByValue(WebElement locator, String dropDownValue) {
        waitUntilElementVisible(locator);
        scrollToElement(locator);
        var select = new Select(locator);
        select.selectByValue(dropDownValue);
    }

    public WebElement dynamic(By path, Object... dynamicPath) {
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

        return driver.findElement(By.xpath(formattedPath));
    }

    public static void waitUntilElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void scrollToElement(WebElement element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void navigateToUrl(String url) {
        driver.navigate().to(url);
    }
}