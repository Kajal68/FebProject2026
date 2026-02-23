package eCommerceSite;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class CopyStandAloneTest2 extends BaseTest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void SubmitOrder(String username, String password, String productName)
			throws IOException, InterruptedException {

		ProductCatlogPage prodCat = loginPage.loginToApp(username, password);
		prodCat.resetPage();

		List<WebElement> productList = prodCat.getListOfProducts();
		prodCat.addProductName(productName);

		CheckOutPage checkOut = new CheckOutPage(driver); // I did not added go to cart page method, instead I'm calling
															// // into below method
		checkOut.getCheckOutDetails();
		Boolean match = checkOut.matchProdctDetails(productName);
		Assert.assertTrue(match);

		PaymentPage pay = new PaymentPage(driver);
		pay.selectOption("IND");
		pay.placeOrder();

		ConfirmPage confirm = new ConfirmPage(driver);
		String confirmMsg = confirm.getConfirmMsg();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(enabled = false, dependsOnMethods = { "SubmitOrder" })
	public void DisplayOrderList() {

		ProductCatlogPage prodCat = loginPage.loginToApp("rosemerry@gmail.com", "Rose@123#");
		prodCat.resetPage();

		OrderedList order = new OrderedList(driver);
		order.goToOrderPage();
		Assert.assertTrue(order.matchProdctDetails(productName));

	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "rosemerry@gmail.com", "Rose@123#", "ZARA COAT 3" },
				{ "johnfoe@gmail.com", "JohnFoe@123", "ADIDAS ORIGINAL" } };

	}

}
