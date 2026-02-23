package eCommerceSite;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class StandAloneTest extends BaseTest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void SubmitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		ProductCatlogPage prodCat = loginPage.loginToApp(input.get("email"), input.get("password"));
		prodCat.resetPage();

		List<WebElement> productList = prodCat.getListOfProducts();
		prodCat.addProductName(input.get("item"));

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

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "rosemerry@gmail.com");
		map.put("password", "Rose@123#");
		map.put("item", "ZARA COAT 3");

		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "johnfoe@gmail.com");
		map1.put("password", "JohnFoe@123");
		map1.put("item", "ADIDAS ORIGINAL");

		return new Object[][] { { map }, { map1 } };

	}

}
