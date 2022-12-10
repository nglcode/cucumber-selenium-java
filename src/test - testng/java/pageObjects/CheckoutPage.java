package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
	
	public WebDriver driver;
	private By productName = By.cssSelector("p.product-name");
	private By applyButton = By.cssSelector("button.promoBtn");
	private By placeOrderButton = By.xpath("//button[text()=\"Place Order\"]");
	
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public WebElement getApplyButton() {
		return driver.findElement(applyButton);
	}
	
	public WebElement getPlaceOrderButton() {
		return driver.findElement(placeOrderButton);
	}

}
