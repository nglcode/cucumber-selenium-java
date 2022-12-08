package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
	
	public String checkoutPageProductName;
	public TestContextSetup testContextSetup;
	public CheckoutPage checkoutPage;
	

	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("validate product name in checkout page matches with Landing Page")
	public void validate_product_name_in_checkout_page_matches_with_landing_page() {
	    checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	    checkoutPageProductName = checkoutPage.getProductName().split("-")[0].trim();
	    Assert.assertEquals(checkoutPageProductName, testContextSetup.landingPageProductName);
	}
	
	@Then("validate apply and place order buttons are displayed")
	public void validate_apply_and_place_order_buttons_are_displayed() {
	    Assert.assertTrue(checkoutPage.getApplyButton().isDisplayed());
	    Assert.assertTrue(checkoutPage.getPlaceOrderButton().isDisplayed());
	}
	

}
