package pages;

import extentions.UIElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends HomePage {

    private final By spanText = By.xpath("//span[text()='%s']");
    private final By inputId = By.xpath("//input[@id='%s']");
    private final By textareaId = By.xpath("//textarea[@id='currentAddress']");
    private final By btnId = By.xpath("//button[@id='%s']");

    UIElements UIElements;
    private WebDriver driver;

    public ElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        UIElements = new UIElements(driver);
    }

    public void textBoxTest(String name, String email, String address, String permAddress) {
        extentions.UIElements.performClick(UIElements.dynamic(spanText, "Text Box"));
        // verify is is clicked

        // enter details
        logger.info("Entering Details:");
        extentions.UIElements.performEnterText(UIElements.dynamic(inputId, "userName"), name);
        logger.info("Entered Name as: " + name);
        extentions.UIElements.performEnterText(UIElements.dynamic(inputId, "userEmail"), email);
        logger.info("Entered Email as: " + email);
        extentions.UIElements.performEnterText(UIElements.dynamic(textareaId, "currentAddress"), address);
        logger.info("Entered Current Address as: " + address);
        extentions.UIElements.performEnterText(UIElements.dynamic(textareaId, "permanentAddress"), permAddress);
        logger.info("Entered Permanent Address as: " + permAddress);
        extentions.UIElements.performClick(UIElements.dynamic(btnId, "submit"));
        logger.info("Clicked on Submit Button");

        // verify form is submitted

    }
}
