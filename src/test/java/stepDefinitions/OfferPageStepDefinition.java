package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	
	public String offerPageProductName;
	public TestContextSetup testContextSetup;
	

	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_the_same_shortname_in_offers_page_to_check_if_product_exists(String shortname) throws InterruptedException {
		testContextSetup.driver.findElement(By.xpath("//a[@href='#/offers']")).click();
		Set<String> windowHandles = testContextSetup.driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
		testContextSetup.driver.switchTo().window(childWindow);
		testContextSetup.driver.findElement(By.id("search-field")).sendKeys(shortname);
		offerPageProductName = testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		System.out.println(offerPageProductName + " was extracted - offerPageProductName");
		Thread.sleep(2000);
	}
	
	@Then("validate product name matches in offers page matches with Landing Page")
	public void validate_product_name_matches_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	}
	
	public void waitSecs(int secs) {
		testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

}
