package pages;

import extentions.UIElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.LocatorReader;
import utilities.OpenAIHelper;

public class HomePage extends BasePage {

    private WebDriver driver;
    private String locators;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

        locators = OpenAIHelper.GetLocatorsForPageAsJson(driver.getPageSource());
        LocatorReader.loadLocatorsFromJson(locators);
    }

    public void navigateToElements() {
        extentions.UIElements.performClick(driver.findElement(LocatorReader.findLocatorByPartialName("Elements")));
    }

}