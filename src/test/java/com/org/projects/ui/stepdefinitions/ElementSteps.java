package com.org.projects.ui.stepdefinitions;

import com.org.hooks.TestContext;
import com.org.projects.ui.pages.ElementsPage;
import io.cucumber.java.en.Then;

public class ElementSteps {

    ElementsPage elementsPage;

    public ElementSteps(TestContext testContext) {
        elementsPage = testContext.getElementsPage();
    }

    @Then("Click on {string}")
    public void click_on_button(String btn) {
        elementsPage.clickOnBtn(btn);
    }

    @Then("User enters {string} as {string}")
    public void user_enters_as(String field, String value) {
        elementsPage.enterTextFieldAndValue(field, value);
    }

    @Then("User clicks on {string} button")
    public void user_clicks_on_button(String btn) {
        elementsPage.clickOnSubmitBtn(btn);
    }
}
