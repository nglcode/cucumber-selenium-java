package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.CartPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CartPageStepDefinition {
	
	public String offerPageProductName;
	public TestContextSetup testContextSetup;
	public CartPage cartPage;
	

	public CartPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@When("user opens cart and proceed to checkout")
	public void user_opens_cart_and_proceed_to_checkout() {
	    cartPage = testContextSetup.pageObjectManager.getCartPage();
	    cartPage.clickCartIcon();
	    cartPage.clickCheckout();
	}

}
