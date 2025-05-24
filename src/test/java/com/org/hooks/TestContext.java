package com.org.hooks;

import com.org.driver.DriverFactory;
import com.org.driver.DriverManager;
import com.org.projects.ui.pages.ElementsPage;
import com.org.projects.ui.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class TestContext {

    private WebDriver driver;
    private HomePage homePage;
    private ElementsPage elementsPage;
    public TestContext() {
        driver = ThreadGuard.protect(new DriverFactory().createInstance());
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public ElementsPage getElementsPage() {
        if (elementsPage == null) {
            elementsPage = new ElementsPage();
        }
        return elementsPage;
    }

//    public WebDriver getDriver() {
//        return DriverManager.getDriver();
//    }
}
