package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public LandingPage landingPage;
	public OffersPage offersPage;
	public CheckoutPage checkoutPage;
	public CartPage cartPage;
	public WebDriver driver;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LandingPage getLandingPage() {
		return landingPage = new LandingPage(driver);
	}

	public OffersPage getOffersPage() {
		return offersPage = new OffersPage(driver);
	}
	
	public CheckoutPage getCheckoutPage() {
		return checkoutPage = new CheckoutPage(driver);
	}
	
	public CartPage getCartPage() {
		return cartPage = new CartPage(driver);
	}
	
}

