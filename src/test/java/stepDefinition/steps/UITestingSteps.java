package stepDefinition.steps;

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
	public void launch_The_Application() {
		uiTestingPage.launchApplication();
	}

	@Then("Navigate to {string}")
	public void navigate_To(String link) {
		uiTestingPage.navigateToSubPage(link);
	}

	@Then("Enter {string} in textbox and verify button text")
	public void enter_in_textbox_and_verify_button_text(String text) {
		uiTestingPage.enterTextandVerifyButtonText(text);
	}

	@Then("Click the button")
	public void click_the_button() {
		uiTestingPage.clickButton();
	}

	@Then("Verify the displayed text")
	public void verify_the_displayed_text() {
		uiTestingPage.verifyDisplayedText();
	}
	
	@Then("Check and verify the visibility of buttons")
	public void check_and_verify_the_visibility_of_buttons() {
		uiTestingPage.verifyVisibilityOfButtons();
	}


}
