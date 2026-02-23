package eCommerceSite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import helperClasses.HelperPage;

public class CheckOutPage extends HelperPage  {
	
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {

		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(css="[routerlink*='/dashboard/cart']")
	WebElement cartLink;

	@FindBy(css=".cartSection h3")
	List<WebElement> prodCartDetails;
	
	@FindBy(css=".totalRow button")
	WebElement checkOutBtn;
	
	public List<WebElement> getCheckOutDetails() {
		
		clickOnElement(cartLink);
		List<WebElement> cartDetails = prodCartDetails;
		for (WebElement cart : cartDetails) { // optional
			System.out.println(cart.getText());
		}
		clickOnElement(checkOutBtn);
		return prodCartDetails;
	}
	
	public boolean matchProdctDetails(String productName) {
		Boolean match = prodCartDetails.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return true;
		
	}
	
//	public void clickOnElement(WebElement ele) { // go to other page
//
//		ele.click();
//	}

}
