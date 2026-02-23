package eCommerceSite;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.RetryListeners;

public class EorrorValidation extends BaseTest {

	@Test(retryAnalyzer = RetryListeners.class)
	public void LoginErrorValidation() {

		String errorMessage = "Incorrect email or password.";
		loginPage.loginToApp("rosemerry@gmail.com", "Rose@12");
		Assert.assertEquals(errorMessage, loginPage.getErrorMsg());

	}

}
