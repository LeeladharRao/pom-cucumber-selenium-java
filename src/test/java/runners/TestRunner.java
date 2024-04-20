package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/"},
		glue = { "stepdefinition" }, tags = "@UITestSampleTwo or @UITestSampleOne" , plugin = {
				"junit:target/cucumber-reports/cucumber.xml", 
				"json:target/cucumber-reports/cucumber.json",
				"html:target/cucumber-reports/cucumber.html",
//				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"
				},
		monochrome = true )

public class TestRunner {

}
