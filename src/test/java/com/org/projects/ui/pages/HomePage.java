package com.org.projects.ui.pages;

import com.org.commons.BasePage;
import com.org.keywords.WebUI;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By lnkElements = By.xpath("//h5[text()='%s']");

    public void clickOnButton(String btn) {
        WebUI.clickElement(WebUI.dynamic(lnkElements, btn));
    }

}
