package eCommerceSite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helperClasses.HelperPage;

public class ProductCatlogPage extends HelperPage {

	WebDriver driver;

	public ProductCatlogPage(WebDriver driver) {

		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// List<WebElement> productList = driver.findElements(By.cssSelector(".mb-3"));

	@FindBy(css = ".mb-3")
	List<WebElement> productList;

	By productBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By waitEle = By.cssSelector("body > app-root > app-dashboard > ngx-spinner");
	By successMsg = By.cssSelector("#toast-container");

	public List<WebElement> getListOfProducts() {

		waitForElement(productBy);
		return productList;
	}

	public WebElement getProductName(String productName) {
		WebElement prod = productList.stream()
				.filter(p -> p.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}

	public void addProductName(String productName) throws InterruptedException {
		WebElement prod = getProductName(productName);
		prod.findElement(addToCart).click();
		waitForElementToDisappear(waitEle);
		waitForElement(successMsg);
	}
}
