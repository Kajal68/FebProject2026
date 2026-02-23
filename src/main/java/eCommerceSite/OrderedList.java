package eCommerceSite;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helperClasses.HelperPage;

public class OrderedList extends HelperPage {

	WebDriver driver;

	public OrderedList(WebDriver driver) {

		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "[routerlink*='myorders']")
	WebElement ordersLink;

	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> orderName;

	@FindBy(css = ".cartSection h3")
	List<WebElement> prodCartDetails;

	@FindBy(css = ".totalRow button")
	WebElement checkOutBtn;

	public List<WebElement> getCheckOutDetails() {

		clickOnElement(ordersLink);
		List<WebElement> cartDetails = orderName;
		for (WebElement cart : cartDetails) { // optional
			System.out.println(cart.getText());
		}
		clickOnElement(checkOutBtn);
		return prodCartDetails;
	}

	public boolean matchProdctDetails(String productName) {
		Boolean match = orderName.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return true;

	}

	public OrderedList goToOrderPage() {
		ordersLink.click();
		OrderedList order = new OrderedList(driver);
		return order;
	}

}
