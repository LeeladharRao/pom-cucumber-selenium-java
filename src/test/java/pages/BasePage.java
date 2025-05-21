package pages;

import extentions.UIElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class BasePage {

    private static WebDriver driver;
    UIElements UIElements;
    Logger logger = Logger.getLogger("MyLogger");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        UIElements = new UIElements(driver);
    }

}
