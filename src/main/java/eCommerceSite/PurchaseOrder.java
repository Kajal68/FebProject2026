package eCommerceSite;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class PurchaseOrder extends BaseTest {
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
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = readJsonData(
				System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

}
