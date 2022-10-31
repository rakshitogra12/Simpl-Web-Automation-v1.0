package commonMethods;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public static WebDriver driver;

	@BeforeTest
	public void setup() {

		System.setProperty("webdriver.chrome.driver",
				"/Users/rakshitogra/eclipse-workspace/Simpl-Web-Automation-v1.0/src/main/Webdrivers/chromedriver");

		driver = new ChromeDriver();

		ChromeOptions opt = new ChromeOptions();

		opt.setPageLoadStrategy(PageLoadStrategy.NORMAL);

	}

	@AfterMethod
	public void takeSnapShot(ITestResult result) {

		if (ITestResult.FAILURE == result.getStatus()) {

			try {

				TakesScreenshot screenshot = (TakesScreenshot) driver;

				File src = screenshot.getScreenshotAs(OutputType.FILE);

				FileUtils.copyFile(src, new File(
						"/Users/rakshitogra/eclipse-workspace/Simpl-Web-Automation-v1.0/src/test/resources/Screenshots/"
								+ result.getName() + ".png"));

				System.out.println("Successfully captured a screenshot for a failure");

			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}

	}

	@AfterTest
	public void teardown() {

		driver.quit();
	}

}
