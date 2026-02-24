package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day3 {

//	@Parameters({"URL","abc/xyz"}) //we can add more values in it

	@Test(dataProvider = "getData")
	public void Selenium(String user, String pass) {
		System.out.println("selenium");
		System.out.println(user);
		System.out.println(pass);

	}

	@Test(enabled = false)
	public void API() {
		System.out.println("api");
		System.out.println("api test");
		System.out.println("api 2");
		System.out.println("api test 2");
	}

	@Parameters({ "URL" })
	@Test
	public void Playwright(String url1) {
		System.out.println("playwright");
		System.out.println(url1);
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[2][2];

		data[0][0] = "1stName";
		data[0][1] = "1stPass";

		data[1][0] = "2ndName";
		data[1][1] = "2ndPass";

		return data;

	}
}
