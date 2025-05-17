package pages;

import extentions.UIElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class BasePage {

    private final WebDriver driver;
    UIElements uiElements;
    Logger logger = Logger.getLogger("MyLogger");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        uiElements = new UIElements(driver);
    }

}
