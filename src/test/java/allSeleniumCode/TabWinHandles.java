package allSeleniumCode;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabWinHandles {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> win=driver.getWindowHandles();
		Iterator<String> it =win.iterator();
		String parentWin=it.next();
		String childWin=it.next();
		driver.switchTo().window(childWin);
		driver.get("https://rahulshettyacademy.com/learning-paths");
		
	    String text=driver.findElements(By.cssSelector("div.p-4 h3")).get(1).getText();
		driver.switchTo().window(parentWin);
		
	    WebElement ele=	driver.findElement(By.xpath("(//input[@name='name'])[1]"));
		
		ele.sendKeys(text);
		
	    File  file = ele.getScreenshotAs(OutputType.FILE);    //WebElement screeenshot
	    
	    FileUtils.copyFile(file, new File("F://img1.png"));
		
	    System.out.println(ele.getRect().getDimension().getHeight());
	    System.out.println(ele.getRect().getDimension().getWidth());
		
		
		driver.quit();
		
		

	}

}
