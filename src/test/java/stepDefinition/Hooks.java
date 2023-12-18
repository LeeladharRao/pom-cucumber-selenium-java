package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.WebDriverManager;

public class Hooks {
	
	private WebDriverManager webDriverManager;
	private WebDriver driver;
	

	@Before(order = 0)
	public void getScenarioFromTestDataExcel() {
		//extract excel data
	}
	
	@Before(order = 1)
	public void launchBrowser() throws IOException {
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();		
	}
	
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order=1)
	public void tearDown() {
		//log error
	}
}
