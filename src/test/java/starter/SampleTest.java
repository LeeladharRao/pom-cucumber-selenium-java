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

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testElements() {
        driver.navigate().to("https://demoqa.com");

        HomePage homePage = new HomePage(driver);
        homePage.navigateToElements();

        ElementsPage elementsPage = new ElementsPage(driver);
        String name = "Adrian K";
        String email = "adrian.k@test.com";
        String address = "Silk Street, Book Ave, USA";
        String permAddress = "Silk Street, Book Ave, USA";
        elementsPage.textBoxTest(name, email, address, permAddress);

        driver.navigate().to("https://demoqa.com");
    }

    @AfterTest
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }

}