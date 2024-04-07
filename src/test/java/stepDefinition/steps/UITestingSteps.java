package stepDefinition.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import managers.WebDriverManager;
import pageobjects.pages.UITestingPage;

public class UITestingSteps {

	UITestingPage uiTestingPage;

	public UITestingSteps() {
		uiTestingPage = new UITestingPage(WebDriverManager.getDriver());
	}

	@Given("launch the Application")
	public void launch_The_Application() {
		uiTestingPage.launchApplication();
	}

	@Then("Navigate to {string}")
	public void navigate_To(String link) {
		uiTestingPage.navigateToSubPage(link);
	}

}
