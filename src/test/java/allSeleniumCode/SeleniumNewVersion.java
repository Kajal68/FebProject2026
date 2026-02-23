package allSeleniumCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class SeleniumNewVersion {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://selectorshub.com/xpath-practice-page/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='90%'");

		//above relativelocator
		WebElement ele = driver.findElement(By.cssSelector("input[title='Email']"));
		String labelName = driver.findElement(with(By.tagName("label")).above(ele)).getText();
		System.out.println(labelName);
		
		//below relativelocator
		js.executeScript("window.scrollBy(0,5490)");
		
		WebElement below = driver.findElement(By.xpath("//label[contains(.,'Expiry Date')]"));
		String val= driver.findElement(with(By.tagName("input")).below(below)).getDomAttribute("value");
		System.out.println(val);

		
		driver.quit();
	}

}
