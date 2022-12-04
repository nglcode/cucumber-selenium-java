package cucumberOptions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions", monochrome = true, dryRun = true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	public WebDriver driver;

	@Given("user is on GreenCard landing page")
	public void user_is_on_green_card_landing_page() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

	}

	@When("user searched with shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) {
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		String landingPageProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println(landingPageProductName + " was extracted - landingPageProductName");
		
		
	}

	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_the_same_shortname_in_offers_page_to_check_if_product_exists(String shortname) {
		driver.findElement(By.xpath("//a[@href='#/offers']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
		driver.switchTo().window(childWindow);
		driver.findElement(By.id("search-field")).sendKeys(shortname);
		String offerPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		System.out.println(offerPageProductName + " was extracted - offerPageProductName");

	}
	
	@Then("validate product name matches in offers page matches with Landing Page")
	public void validate_product_name_matches_in_offers_page_matches_with_landing_page() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
	}

}
