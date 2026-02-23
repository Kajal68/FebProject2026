package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CreateExtentReport {

	static ExtentReports extent;

	@Test
	public void config() {

		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().getTheme().STANDARD.compareTo(Theme.STANDARD);
		reporter.config().getTimeStampFormat();

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA", "Kajal Pagare");

	}

	@Test
	public void launchBrowser() {
		ExtentTest test = extent.createTest("Launching Browser Test");
		WebDriver driver = new ChromeDriver(); //
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //
		driver.manage().window().maximize(); //
		driver.get("https://rahulshettyacademy.com/AutomationPractice/"); //
		System.out.println(driver.getTitle()); //
		test.pass("Launching Browser Test"); // // test.fail("Test got fail"); //
		driver.close(); // extent.flush(); // }

	}
}
