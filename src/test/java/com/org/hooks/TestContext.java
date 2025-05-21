package com.org.hooks;

import com.org.driver.DriverFactory;
import com.org.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class TestContext {

    private WebDriver driver;

    public TestContext() {
        driver = ThreadGuard.protect(new DriverFactory().createInstance());
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
    }

//    public WebDriver getDriver() {
//        return DriverManager.getDriver();
//    }
}
