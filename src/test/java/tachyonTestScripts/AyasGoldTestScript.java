package tachyonTestScripts;

import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadConfig;
import commonMethods.Read_Write_Excel_Tachyon;

public class AyasGoldTestScript extends BaseClass {

	ReadConfig readconfig = new ReadConfig();

	@Test(priority = 1)
	public void AyasGoldMethodCTAButtonStatusCheck() throws Exception {

		String merchantName = "Aya's Gold";

		String ctaBtnStatus_PDP = null;

		String ctaBtnStatus_Ajax = null;

		String ctaBtnStatus_Cart = null;

		ArrayList<String> statusList = new ArrayList<String>();

		driver.get(readconfig.getAyasgoldURL());

		driver.manage().window().maximize();

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id='wigzo_onsite_temp002']")));

		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'✖')]")));

		driver.findElement(By.xpath("//div[contains(text(),'✖')]")).click();
		
		Thread.sleep(5000);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.xpath("(//div[@class='position-relative item']/a)[4]")));

		try {

			if (driver.findElement(By.cssSelector("button[id='simpl_buynow-button']")).isDisplayed()) {

				System.out.println("Tachyon CTA Button is getting displayed on PDP Page");

				ctaBtnStatus_PDP = "PASS";

			} else {

				System.out.println("Simpl Button is not getting displayed on PDP Page");

			}

		} catch (Exception e) {

			System.out.println("Tachyon CTA button is not present on PDP Page");

			ctaBtnStatus_PDP = "FAIL";

		}

		statusList.add(ctaBtnStatus_PDP);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.xpath("//button[contains(@class,'product-add-to-cart-button')]")));

		System.out.println("Since Ajax Cart is not present, hence Tachyon CTA button cannot be visible");

		ctaBtnStatus_Ajax = "N/A";

		statusList.add(ctaBtnStatus_Ajax);

		Thread.sleep(6000);

		driver.switchTo().newWindow(WindowType.TAB);

		driver.get("https://www.ayasgold.com/cart");

		try {

			if (driver.findElement(By.id("simpl_buynow-button")).isDisplayed()) {

				System.out.println("Tachyon CTA Button is getting displayed on View Cart Page");

				ctaBtnStatus_Cart = "PASS";

			} else {

				System.out.println("Simpl Button is not getting displayed on View Cart Page");

			}
		} catch (Exception e) {

			System.out.println("Tachyon CTA button is not present on View Cart Page");

			ctaBtnStatus_Cart = "FAIL";

		}

		statusList.add(ctaBtnStatus_Cart);

		Read_Write_Excel_Tachyon obj = new Read_Write_Excel_Tachyon();

		obj.ReadExcelLoginMethodStatusCheck(statusList, merchantName);

	}

}
