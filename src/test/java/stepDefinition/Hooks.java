package stepDefinition;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.LogManager;
import managers.WebDriverManager;
import utilities.ExcelReaderAndWriter;

public class Hooks {

	WebDriver driver;
	Map<String, String> testDataMaster;
	Map<String, String> testData;

	@Before(order = 0)
	public void getScenarioFromTestDataExcel(Scenario scenario) {
		// extracting excel testdata
		testDataMaster = ExcelReaderAndWriter.ExcelTestDataMasterReader(scenario);
		LogManager.logMessage(testDataMaster.toString());
		testData = ExcelReaderAndWriter.ExcelTestDataFunctionReader(scenario);
		LogManager.logMessage(testData.toString());
	}

	@Before(order = 1)
	public void launchBrowser() throws IOException {
		// creating webdriver session
		this.driver = WebDriverManager.getDriver();
	}

	@After(order = 0)
	public void After() {
		// terminating webdriver session
		WebDriverManager.quitDriver();
	}

}
