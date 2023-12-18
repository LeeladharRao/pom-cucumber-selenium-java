package pageObjects.Pages;

import org.openqa.selenium.WebDriver;

public class SamplePage {
	
	WebDriver driver;
	
	public SamplePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void sampleFunction() {
		System.out.println("funstion page");
	}

}
