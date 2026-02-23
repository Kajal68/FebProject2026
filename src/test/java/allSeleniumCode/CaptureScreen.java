package allSeleniumCode;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreen {
	
	public static void main(String[] args) throws IOException  {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	
	/*
	 * String filePath = System.getProperty("user.dir") + "/docfiles/sample.txt";
	 * File file = new File(filePath);
	 * 
	 * if (file.exists()) { System.out.println("File found at: " +
	 * file.getAbsolutePath()); } else { System.out.println("File not found."); } }
	 */
	
	 String filePath = "F://screenshot.png";
     
     File file = new File(filePath);
     
     // Check if file exists
     if (file.exists()) {
         // Delete the file
         if (file.delete()) {
             System.out.println("File deleted successfully.");
         } else {
             System.out.println("Failed to delete the file.");
         }
     } else {
         System.out.println("File does not exist.");
     }
 

	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src,new File( "F://screenshot.png"));
	
	driver.quit();
	
}
}
