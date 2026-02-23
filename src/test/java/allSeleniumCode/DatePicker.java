package allSeleniumCode;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DatePicker {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/flights/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

		Thread.sleep(2000);
		String pop_up = driver.findElement(By.xpath("//div/p[contains(., 'Sign up/Login now to')]")).getText();
		System.out.println(pop_up);
		Assert.assertTrue(true, pop_up);
		driver.findElement(By.cssSelector("span[class*='Modal__close']")).click();

		driver.findElement(By.xpath("//div[@class='tp-dt-header-icon'][2]//img")).click();

		// zoom out
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='75%'");

		driver.findElement(By.cssSelector(".menu_Flights")).click();
//		driver.findElement(By.xpath("//div[@class='tooltipInfo']")).click();
//		driver.findElement(By.cssSelector("span[class*='Modal__close']")).click();
		driver.findElement(By.xpath("//div[@class='minContainer']")).click();
		driver.findElement(By.cssSelector("label[for='departure']")).click();
//		driver.findElement(By.cssSelector(".DayPicker-Day.DayPicker-Day--selected.DayPicker-Day--today")).click();
		driver.findElement(By.xpath("//div[@class='DayPicker-Day DayPicker-Day--today']//div/p[1]")).click();
	System.out.println(driver.findElement(By.xpath("//label[@for='departure']")).getText());
	}

}
