package tachyonTestScripts;

import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadConfig;
import commonMethods.Read_Write_Excel_Tachyon;

public class ZenvistapackagingsTestScript extends BaseClass {

	ReadConfig readconfig = new ReadConfig();

	@Test(priority = 1)
	public void ZenvistapackagingsMethodUsingPDPPageButtonApprovedScenario() throws Exception {

		driver.get(readconfig.getZenvistaPackagingsURL());

		driver.manage().window().maximize();

		WebElement element1 = driver.findElement(By.xpath(
				"(//a[contains(@href,'empty-black-color-cosmetic-jars-with-rose-gold-cap-and-silver-streak-50gm-pack-of-10')])[1]"));

		Actions builder = new Actions(driver);

		Action mouseOverHome1 = builder.moveToElement(element1).click().build();

		mouseOverHome1.perform();

		driver.findElement(By.xpath("//button[@id='simpl_buynow-button']")).click();

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id='simpl-checkout-iframe']")));

		new WebDriverWait(driver, Duration.ofSeconds(30))
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

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[contains(text(),'Empty Black color cosmetic jars with rose gold cap')]")));

		String productTitle = driver
				.findElement(By.xpath("//div[contains(text(),'Empty Black color cosmetic jars with rose gold cap')]"))
				.getText();

		Thread.sleep(5000);

		String qtyText = driver.findElement(By.xpath("//span[contains(text(),'Qty')]")).getText();

		String cartPrice = driver.findElement(By.xpath("//div[@data-cy='order-detail-price']/span[2]")).getText();

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[contains(text(),'Simpl Pay Later')]")));

		String simplPayLatertext = driver.findElement(By.xpath("//h5[contains(text(),'Simpl Pay Later')]")).getText();

		String paylatertext = driver.findElement(By.id("PAY_LATER-payment-cta")).getText();

		Assert.assertEquals(simplPayLatertext, "Simpl Pay Later",
				"Simpl Pay Later text is not present on the Tachyon Checkout Page");

		Assert.assertEquals(paylatertext, "BUY NOW AND PAY LATER",
				"Pay Later payment option is not present on the Tachyon Checkout Page");

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
	public void ZenvistapackagingsMethodUsingAjaxCartButtonApprovedScenario() throws Exception {

		driver.get(readconfig.getZenvistaPackagingsURL());

		driver.manage().window().maximize();

		WebElement element1 = driver.findElement(By.xpath("(//button[@name='add'])[1]"));

		Actions builder = new Actions(driver);

		Action mouseOverHome1 = builder.moveToElement(element1).click().build();

		mouseOverHome1.perform();

		driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[1]")).click();

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id='simpl-checkout-iframe']")));

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'Enter Mobile Number')]")));

		String text1 = driver.findElement(By.xpath("//p[contains(text(),'Enter Mobile Number')]")).getText();

		String text2 = driver.findElement(By.cssSelector("div[data-cy=\"order-summmery\"]")).getText();

		System.out.println(text1);

		System.out.println(text2);

	}

	@Test(priority = 3)
	public void ZenvistapackagingsMethodUsingPDPPageButtonUnapprovedScenario() throws Exception {

		driver.get(readconfig.getZenvistaPackagingsURL());

		driver.manage().window().maximize();

		WebElement element1 = driver.findElement(By.xpath(
				"(//a[contains(@href,'empty-black-color-cosmetic-jars-with-rose-gold-cap-and-silver-streak-50gm-pack-of-10')])[1]"));

		Actions builder = new Actions(driver);

		Action mouseOverHome1 = builder.moveToElement(element1).click().build();

		mouseOverHome1.perform();

		driver.findElement(By.xpath("//button[@id='simpl_buynow-button']")).click();

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id='simpl-checkout-iframe']")));

		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id='simpl-checkout-iframe']")));

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

	@Test(priority = 4)
	public void ZenvistapackagingsMethodWrongOTPScenario() throws Exception {

		driver.get(readconfig.getZenvistaPackagingsURL());

		driver.manage().window().maximize();

		WebElement element1 = driver.findElement(By.xpath(
				"(//a[contains(@href,'empty-black-color-cosmetic-jars-with-rose-gold-cap-and-silver-streak-50gm-pack-of-10')])[1]"));

		Actions builder = new Actions(driver);

		Action mouseOverHome1 = builder.moveToElement(element1).click().build();

		mouseOverHome1.perform();

		driver.findElement(By.xpath("//button[@id='simpl_buynow-button']")).click();

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id='simpl-checkout-iframe']")));

		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.id("phone-number")));

		driver.findElement(By.id("phone-number")).sendKeys(readconfig.getsuccessMobNo());

		driver.findElement(By.cssSelector("button[data-cy=\"verify-mobile\"]")).click();
		
		new WebDriverWait(driver, Duration.ofSeconds(20))
		.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='otp']")));

		driver.findElement(By.cssSelector("input[id='otp']")).sendKeys("0000");

		Thread.sleep(5000);

		String otpText = driver.findElement(By.cssSelector("span[data-cy=\"otp-error\"]")).getText();

		Assert.assertEquals(otpText, "Invalid OTP", "Invalid OTP text is not present on the OTP Page");

		System.out.println("Invalid OTP text is present on the OTP Page");

	}

	@Test(priority = 6)
	public void ZenvistapackagingsMethodCTAButtonStatusCheck() throws Exception {

		String merchantName = "Zenvista Packagings";

		String ctaBtnStatus_PDP = null;

		String ctaBtnStatus_Ajax = null;

		String ctaBtnStatus_ViewCart = null;

		ArrayList<String> statusList = new ArrayList<String>();

		driver.get(readconfig.getZenvistaPackagingsURL());

		driver.manage().window().maximize();

		WebElement element1 = driver.findElement(By.xpath(
				"(//a[contains(@href,'empty-black-color-cosmetic-jars-with-rose-gold-cap-and-silver-streak-50gm-pack-of-10')])[1]"));

		Actions builder = new Actions(driver);

		Action mouseOverHome1 = builder.moveToElement(element1).click().build();

		mouseOverHome1.perform();
			
		try {

			if (driver.findElement(By.xpath("//button[@id='simpl_buynow-button']")).isDisplayed()) {

				System.out.println("Tachyon CTA Button is getting displayed on PDP Page");

				ctaBtnStatus_PDP = "PASS";

			}

			else {

				System.out.println("Tachyon CTA Button is not getting displayed on POP page");
			}

		} catch (Exception e) {

			System.out.println("Tachyon CTA button is not present on PDP Page");

			ctaBtnStatus_PDP = "FAIL";

		}

		statusList.add(ctaBtnStatus_PDP);
		
		WebElement element2 = driver.findElement(By.xpath("(//button[@name='add'])[1]"));

		Action mouseOverHome2 = builder.moveToElement(element2).click().build();

		mouseOverHome2.perform();

		System.out.println("Since Ajax Cart Page is not getting displayed, Tachyon button cannot be visible.");

		ctaBtnStatus_Ajax = "N/A";

		statusList.add(ctaBtnStatus_Ajax);

		Thread.sleep(3000);

		driver.switchTo().newWindow(WindowType.TAB);

		driver.get("https://zenvistapackagings.in/cart");
		
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='simpl_buynow-button']")));

		try {

			if (driver.findElement(By.xpath("//button[@id='simpl_buynow-button']")).isDisplayed()) {

				System.out.println("Tachyon CTA Button is getting displayed on View Cart Page");

				ctaBtnStatus_ViewCart = "PASS";
			}

			else {

				System.out.println("View Cart Section is visible but Tachyon CTA Button is not");
			}

		} catch (Exception e) {

			System.out.println("Tachyon CTA button is not present on View Cart Page");

			ctaBtnStatus_ViewCart = "FAIL";

		}

		statusList.add(ctaBtnStatus_ViewCart);

		Read_Write_Excel_Tachyon obj = new Read_Write_Excel_Tachyon();

		obj.ReadExcelLoginMethodStatusCheck(statusList, merchantName);

	}

	
	
}
