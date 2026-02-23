package helperClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import eCommerceSite.ProductCatlogPage;

public class HelperPage {
	WebDriver driver;

	public HelperPage(WebDriver driver) {
		this.driver = driver;
	}

	public ProductCatlogPage resetPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='80%'");
		ProductCatlogPage prodCat = new ProductCatlogPage(driver);
		return prodCat;
	}

	public void waitForElement(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForElementToDisappear(By findBy) throws InterruptedException {

		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));

	}

	public void clickOnElement(WebElement element) {
		element.click();
	}

}
