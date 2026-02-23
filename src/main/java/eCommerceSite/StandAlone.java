package eCommerceSite;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAlone {

	public static void main(String[] args) {

		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		LoginPage loginPage = new LoginPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("rosemerry@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Rose@123#");
		driver.findElement(By.id("login")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='80%'");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> productList = driver.findElements(By.cssSelector(".mb-3"));

		WebElement prod = productList.stream()
				.filter(p -> p.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.cssSelector("body > app-root > app-dashboard > ngx-spinner")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		driver.findElement(By.cssSelector("[routerlink*='/dashboard/cart']")).click();
		List<WebElement> cartDetails = driver.findElements(By.cssSelector(".cartSection h3"));
		for (WebElement cart : cartDetails) { // optional
			System.out.println(cart.getText());
		}

		Boolean match = cartDetails.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);

		driver.findElement(By.cssSelector(".totalRow button")).click();

		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector(".form-group input")), "IND").build().perform();

		wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button.ta-item:nth-of-type(2)")));

		driver.findElement(By.cssSelector("button.ta-item:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();

		String confirmMsg = driver.findElement(By.cssSelector("td h1")).getText();
		System.out.println(confirmMsg);
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		driver.quit();
	}

}
