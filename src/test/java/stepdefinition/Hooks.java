package stepdefinition;

import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
		LogManager.logMessage("=".repeat(100));
		testDataMaster = ExcelReaderAndWriter.excelTestDataMasterReader(scenario);
		LogManager.logMessage(testDataMaster.toString());
		testData = ExcelReaderAndWriter.excelTestDataFunctionReader(scenario);
		LogManager.logMessage(testData.toString());
	}

	@Before(order = 1)
	public void launchBrowser() {
		// creating webdriver session
		this.driver = WebDriverManager.getDriver();
	}

	@After(order = 0)
	public void quitBrowser() {
		// terminating webdriver session
		WebDriverManager.quitDriver();
	}

	@After(order = 1)
	public void reports(Scenario scenario) {
		// logging testcase status
		LogManager.logMessage("=".repeat(40)+scenario.getStatus()+"=".repeat(40));

		// Attach screenhot to report
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "Screenshot Attached");
	}

}
