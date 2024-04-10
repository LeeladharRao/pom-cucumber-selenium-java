package pageObjects.Pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import managers.LogManager;
import utilities.ConfigReader;

public class UITestingPage extends BasePage {

	WebDriver driver;

	public UITestingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div//h1")
	public WebElement pageTitle;

	private By subLinkPartialText = By.xpath("//h3/a[text()='%s']");

	@FindBy(how = How.XPATH, using = "//h3")
	private WebElement subPageTitle;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='MyButton']")
	private WebElement inputTextBox;

	@FindBy(how = How.XPATH, using = "(//button[@type='button'])[2]")
	private WebElement button;

	@FindBy(how = How.XPATH, using = "//span[normalize-space(.)='Welcome UserName!']")
	private WebElement textVerify;
	
	private By buttonVisibility = By.xpath("//td//button");
	
	@FindBy(how = How.XPATH, using = "(//td//button)[1]")
	private WebElement firstButtonVisibility;
	
	
	

	public void launchApplication() {
		driver.get(ConfigReader.getProperty(Constants.ConfigConstants.BASEURL));
		LogManager.logMessage(driver.getTitle());
		waitUntilElementVisible(pageTitle);
		LogManager.logMessage("Loaded the Webpage");
	}

	public void navigateToSubPage(String link) {
		waitUntilElementVisible(dynamic(subLinkPartialText, link));
		dynamic(subLinkPartialText, link).click();
		waitUntilElementVisible(subPageTitle);
		Assert.assertTrue(link + " is not displayed", subPageTitle.getText().equalsIgnoreCase(link));
		LogManager.logMessage("Loaded the sub page : " + link);
	}

	public void enterTextandVerifyButtonText(String text) {
		waitUntilElementVisible(inputTextBox);
		inputTextBox.sendKeys(text);
		button.click();
		waitUntilElementVisible(subPageTitle);
		Assert.assertTrue("Button text " + button.getText() + " does not match : " + text,
				button.getText().equalsIgnoreCase(text));
		LogManager.logMessage("Button text " + button.getText() + " matches : " + text);
	}

	public void clickButton() {
		waitUntilElementVisible(button);
		button.click();
		LogManager.logMessage("Clicked on Button");
	}

	public void verifyDisplayedText() {
		waitUntilElementVisible(textVerify);
		String value = Constants.ConfigConstants.WELCOME_USERNAME;
		Assert.assertTrue("Text " + textVerify.getText() + " does not match : " + value, textVerify.getText().equalsIgnoreCase(value));
		LogManager.logMessage("Text " + textVerify.getText() + "matches : " + value);
	}

	public void verifyVisibilityOfButtons() {
		for (WebElement e : driver.findElements(buttonVisibility)) {
			Assert.assertTrue("Button " + e.getText() + " is not displayed", e.isDisplayed());
			LogManager.logMessage("Button " + e.getText() + " is displayed");
		}
		waitUntilElementVisible(firstButtonVisibility);
		firstButtonVisibility.click();
		LogManager.logMessage("All Buttons visibility verified");
	}

}
