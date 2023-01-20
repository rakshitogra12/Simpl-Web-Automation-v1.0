package tachyonTestScripts;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadConfig;
import commonMethods.Read_Write_Excel_Tachyon;

public class FansArmyTestScript extends BaseClass {

	ReadConfig readconfig = new ReadConfig();

	@Test(priority = 1)
	public void FansArmyMethodUsingAjaxCartButtonApprovedScenario() throws Exception {

		String merchantName = "FansArmy";

		driver.get(readconfig.getfansarmyURL());

		driver.manage().window().maximize();

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.xpath("(//a[contains(@href,'/gojo-satoru-oversized-hoodie')])[1]")));

		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i[class='fa fa-info-circle']")));

		driver.findElement(By.cssSelector("i[class='fa fa-info-circle']")).click();

		TakesScreenshot screenshot = (TakesScreenshot) driver;

		File src = screenshot.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File(
				"/Users/rakshitogra/eclipse-workspace/Simpl-Web-Automation-v1.0/src/test/resources/Screenshots1/"
						+ merchantName + "TickerText.png"));

		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("simpl-payin3-dynamic-popup"));

		driver.findElement(By.cssSelector("img[id='close_icon']")).click();

		driver.switchTo().defaultContent();

		Select objSelect = new Select(driver.findElement(By.id("SingleOptionSelector-0")));

		objSelect.selectByVisibleText("L");

		driver.findElement(By.xpath("(//span[contains(text(),'Add to cart')])[1]")).click();

		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[id='simpl_buynow-button']")));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.cssSelector("button[id='simpl_buynow-button'")));

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id='simpl-checkout-iframe']")));

		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.id("phone-number")));

		driver.findElement(By.id("phone-number")).sendKeys(readconfig.getsuccessMobNo());

		driver.findElement(By.cssSelector("button[data-cy=\"verify-mobile\"]")).click();

		Thread.sleep(10000);

		if (driver.findElement(By.cssSelector("img[alt='down']")).isDisplayed()) {

			System.out.println("Advertisement dropdpwn button is working as expected");

		}

		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt=\"down\"]")));

		driver.findElement(By.cssSelector("img[alt=\"down\"]")).click();

		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt=\"down\"]")));

		driver.findElement(By.cssSelector("img[alt=\"down\"]")).click();

		driver.findElement(By.xpath("//p[contains(text(),'Details')]")).click();

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[contains(text(),'Gojo Satoru Oversized Hoodie')]")));

		String productTitle = driver.findElement(By.xpath("//div[contains(text(),'Gojo Satoru Oversized Hoodie')]"))
				.getText();

		Thread.sleep(5000);

		String qtyText = driver.findElement(By.xpath("//span[contains(text(),'Qty')]")).getText();

		String cartPrice = driver.findElement(By.xpath("//div[@data-cy='order-detail-price']/span[2]")).getText();

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[contains(text(),'Simpl Pay Later')]")));

		String simplPayLatertext = driver.findElement(By.xpath("//h5[contains(text(),'Simpl Pay Later')]")).getText();

		String buttonText = driver.findElement(By.id("PAY_LATER-payment-cta")).getText();

		Assert.assertEquals(simplPayLatertext, "Simpl Pay Later",
				"Simpl Pay Later text is not present on the Tachyon Checkout Page");

		Assert.assertEquals(buttonText, "BUY NOW AND PAY LATER",
				"BUY NOW AND PAY LATER text is not present on the Tachyon Checkout Page Button");

		System.out.println(productTitle);

		System.out.println(qtyText);

		System.out.println(cartPrice);

		if (driver.findElement(By.cssSelector("img[alt=\"close\"]")).isDisplayed()) {

			System.out.println("Close button is working as expected");

		}

		driver.findElement(By.cssSelector("img[alt=\"close\"]")).click();

		driver.findElement(By.xpath("//button[contains(text(),'CANCEL ORDER')]")).click();

	}

	@Test(priority = 2)
	public void FansArmyMethodUsingAjaxCartButtonUnapprovedScenario() throws Exception {

		driver.get(readconfig.getfansarmyURL());

		driver.manage().window().maximize();

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.xpath("(//a[contains(@href,'/gojo-satoru-oversized-hoodie')])[1]")));

		Select objSelect = new Select(driver.findElement(By.id("SingleOptionSelector-0")));

		objSelect.selectByVisibleText("L");

		driver.findElement(By.xpath("//span[contains(text(),'Add to cart')])[1]")).click();

		new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='simpl_buynow-button'])[1]")));

		driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[1]")).click();

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id='simpl-checkout-iframe']")));

		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("phone-number")));

		driver.findElement(By.id("phone-number")).sendKeys(readconfig.getblockedMobNo());

		driver.findElement(By.cssSelector("button[data-cy=\"verify-mobile\"]")).click();

		driver.findElement(By.id("phone-number")).sendKeys(readconfig.getblockedMobNo());

		driver.findElement(By.cssSelector("button[data-cy=\"verify-mobile\"]")).click();

		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[contains(text(),'UPI')]")));

		String simplPayLatertext = driver.findElement(By.xpath("//h5[contains(text(),'UPI')]")).getText();

		String buttontext = driver.findElement(By.xpath("//button[contains(text(),'CONTINUE TO PAY')]")).getText();

		Assert.assertEquals(simplPayLatertext, "UPI", "Simpl Pay Later text is present on the Tachyon Checkout Page");

		System.out.println(buttontext);

		System.out.println("Simpl Pay Later text is not present on the Tachyon Checkout Page");

	}

	@Test(priority = 3)
	public void FansArmyMethodWrongOTPScenario() throws Exception {

		driver.get(readconfig.getfansarmyURL());

		driver.manage().window().maximize();

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.xpath("(//a[contains(@href,'/gojo-satoru-oversized-hoodie')])[1]")));

		Select objSelect = new Select(driver.findElement(By.id("SingleOptionSelector-0")));

		objSelect.selectByVisibleText("L");

		driver.findElement(By.xpath("//span[contains(text(),'Add to cart')])[1]")).click();

		new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='simpl_buynow-button'])[1]")));

		driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[1]")).click();

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id='simpl-checkout-iframe']")));

		new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.elementToBeClickable(By.id("phone-number")));

		driver.findElement(By.id("phone-number")).sendKeys(readconfig.getsuccessMobNo());

		driver.findElement(By.cssSelector("button[data-cy=\"verify-mobile\"]")).click();

		Thread.sleep(10000);

		String otpText = driver.findElement(By.cssSelector("span[data-cy=\"otp-error\"]")).getText();

		Assert.assertEquals(otpText, "Invalid OTP", "Invalid OTP text is not present on the OTP Page");

		System.out.println("Invalid OTP text is present on the OTP Page");

	}

	@Test(priority = 4)
	public void FansArmyMethodCTAButtonStatusCheck() throws Exception {

		String merchantName = "Fans Army";

		String ctaBtnStatus_PDP = null;

		String ctaBtnStatus_Ajax = null;

		String ctaBtnStatus_Cart = null;

		ArrayList<String> statusList = new ArrayList<String>();

		driver.get(readconfig.getfansarmyURL());

		driver.manage().window().maximize();

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.xpath("(//div[@class='product']/div/div/div/div/a)[17]")));

		try {

			if (driver.findElement(By.cssSelector("button[id='simpl_buynow-button']")).isDisplayed()) {

				System.out.println("Tachyon CTA Button is getting displayed on PDP Page");

				ctaBtnStatus_PDP = "PASS";

			} else {

				System.out.println("Tachyon CTA Button is not getting displayed on PDP Page");

			}

		} catch (Exception e) {

			System.out.println("Tachyon CTA Button is not present on PDP Page");

			ctaBtnStatus_PDP = "FAIL";

		}

		statusList.add(ctaBtnStatus_PDP);

		driver.findElement(By.xpath("(//label/span[contains(text(),'L')])[1]")).click();

		driver.findElement(By.cssSelector("button[name='add']")).click();

		System.out.println("Ajax Cart is not present hence Tachyon CTA Button cannot be present");

		ctaBtnStatus_Ajax = "N/A";

		statusList.add(ctaBtnStatus_Ajax);

		Thread.sleep(6000);

		driver.switchTo().newWindow(WindowType.TAB);

		driver.get("https://www.fansarmy.in/cart");

		try {

			if (driver.findElement(By.cssSelector("button[id='simpl_buynow-button']")).isDisplayed()) {

				System.out.println("Tachyon CTA Button is getting displayed on View Cart Page");

				ctaBtnStatus_Cart = "PASS";

			} else {

				System.out.println("Tachyon CTA Button is not getting displayed on View Cart Page");

			}
		} catch (Exception e) {

			System.out.println("Tachyon CTA Button is not present on View Cart Page");

			ctaBtnStatus_Cart = "FAIL";

		}

		statusList.add(ctaBtnStatus_Cart);

		Read_Write_Excel_Tachyon obj = new Read_Write_Excel_Tachyon();

		obj.ReadExcelLoginMethodStatusCheck(statusList, merchantName);

	}

}
