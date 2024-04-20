package managers;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import constants.Constants;
import utilities.ConfigReader;

public class WebDriverManager {

	private static WebDriver driver;

	private static WebDriver createDriver() {
		String session = ConfigReader.getProperty(Constants.ConfigConstants.SESSION);
		Assert.assertNotNull(session);
		LogManager.logMessage("Executing in : " + session);
		
		String browser = ConfigReader.getProperty(Constants.ConfigConstants.BROWSER);
		Assert.assertNotNull(browser);
		LogManager.logMessage("Executing in : " + browser);

		if (session.equalsIgnoreCase(Constants.ConfigConstants.LOCAL)) {
			if (browser.equalsIgnoreCase(Constants.ConfigConstants.BROWSER_CHROME)) {
				ChromeOptions options = new ChromeOptions();
				driver = new ChromeDriver(options);
			} else if (browser.equalsIgnoreCase(Constants.ConfigConstants.BROWSER_FIREFOX)) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase(Constants.ConfigConstants.BROWSER_EDGE)) {
				driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
		} else if (session.equalsIgnoreCase(Constants.ConfigConstants.REMOTE)) {
			if (browser.equalsIgnoreCase(Constants.ConfigConstants.BROWSER_CHROME)) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				driver = new ChromeDriver(options);
			} else if (browser.equalsIgnoreCase(Constants.ConfigConstants.BROWSER_FIREFOX)) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase(Constants.ConfigConstants.BROWSER_EDGE)) {
				driver = new EdgeDriver();
			}
		} else {
			Assert.assertTrue("Browser is set as "+browser+", Please set the browser as 'local' or 'remote'", 
				!browser.equalsIgnoreCase(Constants.ConfigConstants.LOCAL) || !browser.equalsIgnoreCase(Constants.ConfigConstants.REMOTE));
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));

		return driver;
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			driver = createDriver();
		}
		return driver;
	}

	public static void quitDriver() {
		driver.quit();
		driver = null;
	}

}
