package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	private By search = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("h4.product-name");
	private By topDeals = By.xpath("//a[@href='#/offers']");
	private By incrementButton = By.cssSelector("a.increment");
	private By addToCartButton = By.cssSelector("div.product-action button");
	
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	
	public String getSearchText(String name) {
		return driver.findElement(search).getText();
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public void selectTopDeals() {
		driver.findElement(topDeals).click();
	}
	
	public void clickIncrementButton() {
		driver.findElement(incrementButton).click();
	}
	
	public void clickAddToCartButton() {
		driver.findElement(addToCartButton).click();
	}

}
