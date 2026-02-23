package allSeleniumCode;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GreenKart {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// collect the list from ui

		List<WebElement> eleList = driver.findElements(By.xpath("//table//tr/td[1]"));

		// sort the list

		List<String> ogList = eleList.stream().map(s -> s.getText()).collect(Collectors.toList());
		ogList.forEach(System.out::println);

		// Sorted og list

		List<String> sortedList = ogList.stream().sorted().collect(Collectors.toList());
		sortedList.forEach(System.out::println);
		// compare list

		// Assert.assertTrue(ogList.equals(sortedList));

		List<String> price;

		// scan the name column with getText ->Beans->print the price of the Rice

		do

		{

			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

			price = rows.stream().filter(s -> s.getText().contains("Mango"))

					.map(s -> getPriceVeggie(s)).collect(Collectors.toList());

			price.forEach(a -> System.out.println(a));

			if (price.size() < 1)

			{

				driver.findElement(By.cssSelector("[aria-label='Next']")).click();

			}

		} while (price.size() < 1);
		driver.quit();

	}

	private static String getPriceVeggie(WebElement s) {

		// TODO Auto-generated method stub

		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();

		return pricevalue;

	 

	}
	

}
