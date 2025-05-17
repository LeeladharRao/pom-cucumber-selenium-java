package pages;

import extentions.UIElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    private WebDriver driver;

    //Locators
    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement lnkElements;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToElements() {
        UIElements.performClick(lnkElements);
    }

    public void navigateToHomepage() {
        UIElements.navigateToUrl("https://demoqa.com");
    }

}