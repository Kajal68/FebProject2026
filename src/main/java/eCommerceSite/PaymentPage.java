package eCommerceSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helperClasses.HelperPage;

public class PaymentPage extends HelperPage {

	WebDriver driver;

	public PaymentPage(WebDriver driver) {

		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	By selectCountry = By.cssSelector("button.ta-item:nth-of-type(2)");

	@FindBy(css = ".form-group input")
	WebElement selectCountryTextbox;

	@FindBy(css = "button.ta-item:nth-of-type(2)")
	WebElement selectItem;

	@FindBy(css = ".action__submit")
	WebElement submit;

	public void selectOption(String option) {
		Actions a = new Actions(driver);
		a.sendKeys(selectCountryTextbox, option).build().perform();
		waitForElement(selectCountry);
		clickOnElement(selectItem);

	}

	public void placeOrder() {
		clickOnElement(submit);
	}
}
