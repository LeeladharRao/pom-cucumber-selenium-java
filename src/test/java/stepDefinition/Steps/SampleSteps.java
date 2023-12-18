package stepDefinition.Steps;

import io.cucumber.java.en.Given;
import managers.WebDriverManager;
import pageObjects.Pages.SamplePage;

public class SampleSteps {
	
	SamplePage samplePage;
	
	public SampleSteps() {
		samplePage = new SamplePage(WebDriverManager.getDriver());
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		System.out.println("inside stepdefinition");
		samplePage.sampleFunction();
	}


}
