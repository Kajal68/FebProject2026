package eCommerceSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helperClasses.HelperPage;

public class ConfirmPage extends HelperPage {
	

	WebDriver driver;

	public ConfirmPage(WebDriver driver) {

		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(css="td h1")
	WebElement confirmMsg;
	
	public String getConfirmMsg() {
	String	msg=confirmMsg.getText();
	System.out.println(msg);
	return msg;

	}

	public boolean equalsIgnoreCase(String string) {
		// TODO Auto-generated method stub
		return false;
	}

}
