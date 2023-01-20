package tachyonTestScripts;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadConfig;
import commonMethods.Read_Write_Excel_Tachyon;

public class MizunoTestScript extends BaseClass {

	ReadConfig readconfig = new ReadConfig();

	@Test(priority = 1)
	public void MizunoMethodCTAButtonStatusCheck() throws Exception {

		String merchantName = "Mizuno";

		String ctaBtnStatus_PDP = null;

		String ctaBtnStatus_Ajax = null;

		String ctaBtnStatus_Cart = null;

		ArrayList<String> statusList = new ArrayList<String>();

		driver.get(readconfig.getMizunoURL());

		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//a[@class='caption upper'])[1]")).click();

		Thread.sleep(5000);

		if (driver.findElement(By.id("simpl_buynow-button")).isDisplayed()) {

			System.out.println("Tachyon CTA Button is getting displayed on PDP Page");

			ctaBtnStatus_PDP = "PASS";

		} else {

			System.out.println("Tachyon CTA Button is not getting displayed on PDP Page");

			ctaBtnStatus_PDP = "FAIL";

		}

		statusList.add(ctaBtnStatus_PDP);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.cssSelector("button[name='add']")));

		System.out.println("Ajax Cart page is not present hence Tachyon CTA button cannot be visible");

		ctaBtnStatus_Ajax = "N/A";

		statusList.add(ctaBtnStatus_Ajax);

		Thread.sleep(6000);

		driver.switchTo().newWindow(WindowType.TAB);

		driver.get("https://mizunobadmintonindia.com/cart");

		try {

			if (driver.findElement(By.xpath("//button[simpl_buynow-button]")).isDisplayed()) {

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
