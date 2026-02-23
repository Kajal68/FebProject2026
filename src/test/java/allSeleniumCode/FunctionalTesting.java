package allSeleniumCode;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunctionalTesting {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		int j=0;

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom='90%'");
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.cssSelector("#Email")).sendKeys("rose.merry@gmail.com");
		driver.findElement(By.cssSelector("#Password")).sendKeys("rose123");
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		
	   WebElement ele=driver.findElement(By.cssSelector("ul.top-menu > li:nth-child(1) > a"));
		System.out.println(ele.getText());
		ele.click();
		
		js.executeScript("window.scrollBy(0,300)");
		
		String[] items= {"Computing and Internet","Fiction"};
		
		List<WebElement> addProduct = driver.findElements(By.cssSelector("h2.product-title"));
		
		for(int i =0; i<addProduct.size();i++) {
			
			String product = addProduct.get(i).getText();
			List<String> array=Arrays.asList(items);
			
			if(array.contains(product)) {
				j++;
				driver.findElements(By.xpath("//input[@value='Add to cart']")).get(i).click();
				break;
			}
			 if(j==items.length){
				 
				 System.out.println("Data is not matching");
				 
				 break;
				
			}
		}
		
		
		
	}

}
