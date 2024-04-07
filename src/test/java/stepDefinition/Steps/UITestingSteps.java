package stepDefinition.Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import managers.WebDriverManager;
import pageObjects.Pages.UITestingPage;

public class UITestingSteps {

	UITestingPage uiTestingPage;

	public UITestingSteps() {
		uiTestingPage = new UITestingPage(WebDriverManager.getDriver());
	}

	@Given("launch the Application")
	public void launch_the_application() {
		uiTestingPage.launchApplication();
	}

	@Then("Navigate to {string}")
	public void navigate_to(String link) {
		uiTestingPage.navigateToSubPage(link);
	}

}
