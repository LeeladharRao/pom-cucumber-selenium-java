package starter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;

import java.io.File;


public class SampleTest {

    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("adblock.crx"));
        driver = new ChromeDriver(options);

        driver.navigate().to("https://demoqa.com");
        driver.manage().window().maximize();
    }

    @Test
    public void testElements() {
        // initialize
        HomePage homePage = new HomePage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);

        // parameters
        String name = "Adrian K";
        String email = "adrian.k@test.com";
        String address = "Silk Street, Book Ave, USA";
        String permAddress = "Silk Street, Book Ave, USA";

        homePage.navigateToElements();
        elementsPage.textBoxTest(name, email, address, permAddress);
        homePage.navigateToHomepage();
    }

    @AfterTest
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }

}