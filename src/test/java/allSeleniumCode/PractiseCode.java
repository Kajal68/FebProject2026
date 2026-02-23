package allSeleniumCode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class PractiseCode {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		// driver.quit();

		// Radio buttons
		Assert.assertFalse(
				driver.findElement(By.xpath("//fieldset[legend='Radio Button Example']//label[1]")).isSelected());
		driver.findElement(By.xpath("//fieldset[legend='Radio Button Example']//label[1]//input[@value='radio1']"))
				.click();
		Assert.assertTrue(driver.findElement(By.xpath("//label[1]//input[@value='radio1']")).isSelected());
		// System.out.println(radio1);
		driver.findElement(By.xpath("//label[2]//input[@value='radio2']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//label[2]//input[@value='radio2']")).isSelected());
		// boolean radio2 , System.out.println(radio2);

		// driver.quit();

		// Handling auto suggestive dropdown
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("Ind");
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		for (WebElement opt : options) {
			if (opt.getText().equalsIgnoreCase("India")) {
				opt.click();
				break;
			}
		}
		// driver.quit();

		// Handling checkboxes and get size of them
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='BoxOption1']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='BoxOption1']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='BoxOption1']")).isSelected());

		// count the checkboxes present on ui

		System.out.println(driver.findElements(By.xpath("//div[@id='checkbox-example']//input")).size());
		// driver.quit();

		// Switch to window or Window handling with new window open
		// Store parent window
		
		  String parentWindow = driver.getWindowHandle();
		  
		  // Click link that opens new tab
		  driver.findElement(By.xpath("//button[@id='openwindow']")).click();
		  
		  // Switch to new window 
		  for(String window : driver.getWindowHandles()) {
		   if (!window.equals(parentWindow)){ 
		    driver.switchTo().window(window);
		  System.out.println("New Window Title: " + driver.getTitle()); driver.close();
		  // close new window } }
		  
		  // Switch back to parent driver.switchTo().window(parentWindow); //
		 // driver.quit();
		  
		  
		  // Switch to window or Window handling with new tab open
		  
		  String parentwin = driver.getWindowHandle();
		  
		  driver.findElement(By.xpath("//a[@id='opentab']")).click();
		  for(String secwin:driver.getWindowHandles()){
		  
		   if(!secwin.equals(parentwin)) {
		    driver.switchTo().window(secwin);
		   System.out.println("New Tab win: "+driver.getTitle()); 
		   driver.close(); 
		   }
		  
		  } 
		  driver.switchTo().window(parentwin);
		 
		// driver.quit();

		// Switch to alert or Handle alerts

		
		  driver.findElement(By.cssSelector("#name")).sendKeys("Kajal");
		  driver.findElement(By.cssSelector("#alertbtn")).click();
		  System.out.println(driver.switchTo().alert().getText());
		  driver.switchTo().alert().accept();
		  
		  driver.findElement(By.id("confirmbtn")).click();
		  System.out.println(driver.switchTo().alert().getText());
		  driver.switchTo().alert().dismiss();
		 
		
		// Handle Mouse over
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,950)");
		
		WebElement ele=driver.findElement(By.xpath("//div[@class='mouse-hover']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='mouse-hover']//following-sibling::a"));
		for(WebElement elem:list) {
		System.out.println(elem.getText());
		}
		//driver.quit();
	}
		 
   }  
 }
}
