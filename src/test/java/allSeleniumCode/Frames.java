package allSeleniumCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practice-automation.com/iframes/?utm_source=copilot.com");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	    System.out.println(driver.findElements(By.tagName("iframe")).size());
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    
		js.executeScript("document.body.style.zoom='80%'");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,200)");
		
		// Switch to Playwright iframe
		driver.switchTo().frame("top-iframe");
		System.out.println(driver.findElement(By.tagName("h1")).getText());

		// Switch back
		driver.switchTo().defaultContent();
		
		js.executeScript("window.scrollBy(0,200)");

		// Switch to Selenium iframe
		driver.switchTo().frame("bottom-iframe");
		System.out.println(driver.findElement(By.tagName("h1")).getText());

		// Back to main page
		driver.switchTo().defaultContent();

	   
	}

}
