package pages;

import extentions.UIElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.LocatorReader;
import utilities.OpenAIHelper;

public class ElementsPage extends HomePage {

    private WebDriver driver;
    private String locators;

    public ElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

        locators = OpenAIHelper.GetLocatorsForPageAsJson(driver.getPageSource());
        LocatorReader.loadLocatorsFromJson(locators);
    }

    public void textBoxTest(String name, String email, String address, String permAddress) {
        extentions.UIElements.performClick(driver.findElement(LocatorReader.findLocatorByPartialName("Text Box")));
        // verify is is clicked

        // enter details
        logger.info("Entering Details:");
        extentions.UIElements.performEnterText(driver.findElement(LocatorReader.findLocatorByPartialName("userName")), name);
        logger.info("Entered Name as: " + name);
        extentions.UIElements.performEnterText(driver.findElement(LocatorReader.findLocatorByPartialName("userEmail")), email);
        logger.info("Entered Email as: " + email);
        extentions.UIElements.performEnterText(driver.findElement(LocatorReader.findLocatorByPartialName("currentAddress")), address);
        logger.info("Entered Current Address as: " + address);
        extentions.UIElements.performEnterText(driver.findElement(LocatorReader.findLocatorByPartialName("permanentAddress")), permAddress);
        logger.info("Entered Permanent Address as: " + permAddress);
        extentions.UIElements.performClick(driver.findElement(LocatorReader.findLocatorByPartialName("submit")));
        logger.info("Clicked on Submit Button");

        // verify form is submitted

    }
}
