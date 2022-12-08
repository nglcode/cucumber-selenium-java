package stepDefinitions;

import java.time.Duration;
import java.util.stream.IntStream;

import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	
	public String offerPageProductName;
	public TestContextSetup testContextSetup;
	public LandingPage landingPage;
	

	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Given("user is on GreenCard landing page")
	public void user_is_on_green_card_landing_page() {
	}

	@When("^user searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) throws InterruptedException {
		landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.searchItem(shortname);
		Thread.sleep(2000);
		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageProductName + " was extracted - landingPageProductName");
	}
	
	@When("^user adds (.+) items of (.+) to the cart$")
	public void user_adds_items_of_tom_to_the_cart(Integer quantity, String shortname) {
		landingPage.clickIncrementButton(quantity);
		landingPage.clickAddToCartButton();
	}

}
