package pageObjects.Pages;

import org.openqa.selenium.WebDriver;

import constants.Constants;
import managers.LogManager;
import utilities.ConfigReader;

public class UITestingPage extends BasePage {

	WebDriver driver;

	public UITestingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void launchApplication() {
		driver.get(ConfigReader.getProperty(Constants.ConfigConstants.BASEURL));
		LogManager.logMessage("Navigated to Webpage");

	}

	public void navigateToSubPage(String link) {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			LogManager.logErrorMessage(e);
		}

	}

}
