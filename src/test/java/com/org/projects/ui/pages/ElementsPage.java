package com.org.projects.ui.pages;

import com.org.commons.BasePage;
import com.org.constants.Constants;
import com.org.keywords.WebUI;
import com.org.utils.LogManager;
import org.openqa.selenium.By;

public class ElementsPage extends BasePage {

    private final By spanText = By.xpath("//span[text()='%s']");
    private final By inputText = By.xpath("//label[text()='%s']/ancestor::div[contains(@class, 'row')]//input");
    private final By textareaText = By.xpath("//label[text()='%s']/ancestor::div[contains(@class, 'row')]//textarea");
    private final By btnText = By.xpath("//button[text()='%s']");

    public void clickOnBtn(String btn) {
        WebUI.clickElement(WebUI.dynamic(spanText, btn));
    }

    public void enterTextFieldAndValue(String field, String value) {
        switch (field) {
            case Constants.FULL_NAME:
            case Constants.EMAIL:
                WebUI.setText(WebUI.dynamic(inputText, field), value);
                break;
            case Constants.CURRENT_ADDRESS:
            case Constants.PERMANENT_ADDRESS:
                WebUI.setText(WebUI.dynamic(textareaText, field), value);
                break;
            default:
                LogManager.error(field + " is not defined");
        }
    }

    public void clickOnSubmitBtn(String btn) {
        WebUI.clickElement(WebUI.dynamic(btnText, btn));
    }
}
