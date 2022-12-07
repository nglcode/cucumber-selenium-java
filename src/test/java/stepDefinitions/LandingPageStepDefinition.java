package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	
	public String offerPageProductName;
	public TestContextSetup testContextSetup;
	

	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Given("user is on GreenCard landing page")
	public void user_is_on_green_card_landing_page() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		testContextSetup.driver = new ChromeDriver();
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}

	@When("user searched with shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) throws InterruptedException {
		testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
		Thread.sleep(2000);
		testContextSetup.landingPageProductName = testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageProductName + " was extracted - landingPageProductName");
	}
	
	public void waitSecs(int secs) {
		testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

}
