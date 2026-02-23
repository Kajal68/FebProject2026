package allSeleniumCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenBrowser {
	
	public WebDriver driver;
	
	@Test
	public void OpenBrowser() {

		//System.setProperty("webdriver.chrome.driver", "E:\\Downloads data\\Driver\\New folder\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
	    driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/?&ext_vrnc=hi&tag=googinhydr1-21&ref=pd_sl_1aeuamiuit_b&adgrpid=58746164597&hvpone=&hvptwo=&hvadid=617721280249&hvpos=&hvnetw=g&hvrand=8996319434105497718&hvqmt=b&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1007788&hvtargid=kwd-298741529014&hydadcr=5903_2362026&mcid=d1a83ba0cb4d35369c396cac55ec4ae4");
	   
	//	String ogname="";
	  String name=driver.findElement(By.cssSelector("#nav-main")).getText();
	  System.out.println(name);
	  driver.quit();
	 // Assert.assertEquals(ogname, name);
	}

}
