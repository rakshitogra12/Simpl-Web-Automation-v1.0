package tachyonTestScripts;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadConfig;
import commonMethods.Read_Write_Excel_Tachyon;

public class FridoMasksTestScript extends BaseClass {

	ReadConfig readconfig = new ReadConfig();

	@Test(priority = 1)
	public void FridoMasksMethodCTAButtonStatusCheck() throws Exception {

		String merchantName = "Frido Masks";

		String ctaBtnStatus_PDP = null;

		String ctaBtnStatus_Ajax = null;

		String ctaBtnStatus_Cart = null;

		ArrayList<String> statusList = new ArrayList<String>();

		driver.get(readconfig.getFridoMaskURL());

		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//a[contains(text(),'Frido Ultimate Pro ')])[1]")).click();

		try {

			if (driver.findElement(By.id("simpl_buynow-button")).isDisplayed()) {

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
				driver.findElement(By.cssSelector("button[name='add'")));
		
		Thread.sleep(5000);

		try {

			if (driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[2]")).isDisplayed()) {

				System.out.println("Tachyon CTA Button is getting displayed on Ajax Cart Page");

				ctaBtnStatus_Ajax = "PASS";

			} else {

				System.out.println("Simpl Button is not getting displayed on Ajax Cart Page");

			}
		} catch (Exception e) {

			System.out.println("Tachyon CTA button is not present on Ajax Cart Page");

			ctaBtnStatus_Ajax = "FAIL";

		}

		statusList.add(ctaBtnStatus_Ajax);

		Thread.sleep(6000);

		driver.switchTo().newWindow(WindowType.TAB);

		driver.get("https://fridomask.com/cart");

		try {

			if (driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[1]")).isDisplayed()) {

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
