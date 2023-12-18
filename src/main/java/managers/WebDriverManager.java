package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import constants.Constants;

public class WebDriverManager {
	
	private static WebDriver driver;

	private static WebDriver createDriver() {
		String browser = "edge";
		String session = "local";
		
		System.out.println("session is set as "+session);
		System.out.println("browser is set as "+browser);
		
		if (session.equalsIgnoreCase("local")) {
			if (browser.equalsIgnoreCase(Constants.ConfigConstants.BROWSER_CHROME)) {
				driver = new ChromeDriver();			
			} else if (browser.equalsIgnoreCase(Constants.ConfigConstants.BROWSER_FIREFOX)) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase(Constants.ConfigConstants.BROWSER_EDGE)) {
				driver = new EdgeDriver();
			}
		}
		
		return driver;
	}
	
	public static WebDriver getDriver() {
		if (driver == null) {
			driver = createDriver();
		}
		return driver;
	}
	
}
