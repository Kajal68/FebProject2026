package eCommerceSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		// initialization

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// WebElement userEmail = driver.findElement(By.id("userEmail"));

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement loginBtn;

	@FindBy(id = "toast-container")
	WebElement errorMsg;

	public ProductCatlogPage loginToApp(String user, String pass) {
		userEmail.sendKeys(user);
		userPassword.sendKeys(pass);
		loginBtn.click();
		ProductCatlogPage prodCat = new ProductCatlogPage(driver);
		return prodCat;
	}

	public void goToURL() {
		driver.get("https://rahulshettyacademy.com/client");

	}

	public String getErrorMsg() {

		String msg = errorMsg.getText();
		return msg;

	}

}
