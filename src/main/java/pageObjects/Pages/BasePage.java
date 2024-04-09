package pageObjects.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(150));
	}

	public WebElement dynamic(By path, Object... dynamicPath) {
		String locatorString = path.toString();
		String locatorType = "";
		String locatorPath = "";
		String locatorArray[] = locatorString.split(": ");
		if (locatorArray.length <= 2) {
			locatorPath = locatorArray[1];
		} else {
			locatorType = locatorArray[0];
			locatorPath = locatorString.replace(locatorType + ": ", "");
		}
		locatorPath = String.format(locatorPath, dynamicPath);

		return driver.findElement(By.xpath(locatorPath));
	}

	public void waitUntilElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
