package com.org.projects.ui.stepdefinitions;

import com.org.commons.BaseSteps;
import com.org.hooks.TestContext;
import com.org.keywords.WebUI;
import com.org.projects.ui.pages.HomePage;
import com.org.utils.LogManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps extends BaseSteps {

    HomePage homepage;

    public HomePageSteps(TestContext testContext) {
        homepage = testContext.getHomePage();
    }


    @Given("User navigate to url {string}")
    public void user_navigate_to_url(String url) {
        WebUI.navigateToUrl(url);
    }

    @Given("Click on {string} button")
    public void click_on_button(String btn) {
        homepage.clickOnButton(btn);
    }

    @Then("User is Navigated to {string} Page")
    public void user_is_navigated_to_page(String string) {
        LogManager.info("user_is_navigated_to_page");
    }

}
