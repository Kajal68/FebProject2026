package allSeleniumCode;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountLinks {

	public static void main(String[] args) throws InterruptedException {

		// 1. Give me the count of links on the page.
		// 2. Count of footer section-

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");

		System.out.println(driver.findElement(By.xpath("//a[contains(., 'Latest News')]")).getText());

		WebElement footerEle = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerEle.findElements(By.tagName("a")).size());

		WebElement links = footerEle.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[2]/ul"));

		int count=links.findElements(By.tagName("a")).size();
		System.out.println(count);
		
		for(int i =1;i<count;i++) {
			
			String clickOnTab= Keys.chord(Keys.CONTROL,Keys.ENTER);
			links.findElements(By.tagName("a")).get(i).sendKeys(clickOnTab);
			Thread.sleep(1000);
		}
		
		Set<String> abc=driver.getWindowHandles();
		Iterator<String> it=abc.iterator();
		
		while(it.hasNext()) {
			
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			
		}
         driver.quit();
	}

}
