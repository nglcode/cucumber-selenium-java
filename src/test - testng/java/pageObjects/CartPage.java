package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	
	public WebDriver driver;
	private By cartIcon = By.cssSelector("a.cart-icon");
	private By checkoutButton = By.cssSelector("div.action-block button");
	
	
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickCartIcon() {
		driver.findElement(cartIcon).click();
	}
	
	public void clickCheckout() {
		driver.findElement(checkoutButton).click();
	}

}
