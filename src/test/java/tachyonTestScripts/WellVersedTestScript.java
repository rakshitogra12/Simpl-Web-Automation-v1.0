package tachyonTestScripts;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadConfig;

public class WellVersedTestScript extends BaseClass {

	ReadConfig readconfig = new ReadConfig();

	@Test(priority = 1)
	public void WellVersedMethodUsingAjaxCartButtonApprovedScenario() throws Exception {

		driver.get(readconfig.getwellversedURL());

		driver.manage().window().maximize();

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(
				By.xpath("(//a[contains(@href,'electrolyte-powder-for-instant-energy-and-hydration')])[1]")));

		driver.findElement(By.cssSelector("button[id='add-to-cart']")).click();

		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='simpl_buynow-button'])[1]")));

		driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[1]")).click();

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id='simpl-checkout-iframe']")));

		new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.elementToBeClickable(By.id("phone-number")));

		driver.findElement(By.id("phone-number")).sendKeys(readconfig.getsuccessMobNo());

		driver.findElement(By.cssSelector("button[data-cy=\"verify-mobile\"]")).click();

		Thread.sleep(10000);

		if (driver.findElement(By.cssSelector("img[alt='down']")).isDisplayed()) {

			System.out.println("Advertisement dropdown button is working as expected");

		}

		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt=\"down\"]")));

		driver.findElement(By.cssSelector("img[alt=\"down\"]")).click();

		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt=\"down\"]")));

		driver.findElement(By.cssSelector("img[alt=\"down\"]")).click();

		driver.findElement(By.xpath("//p[contains(text(),'Details')]")).click();

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//div[contains(text(),'NEW & IMPROVED Wellcore - Pre Workout Supplement (330g, 30 Servings) | Orange | Explosive Strength, Powerful Pumps, & Laser-Sharp Focus | No Caffeine')]")));

		String productTitle = driver.findElement(By.xpath(
				"//div[contains(text(),'NEW & IMPROVED Wellcore - Pre Workout Supplement (330g, 30 Servings) | Orange | Explosive Strength, Powerful Pumps, & Laser-Sharp Focus | No Caffeine')]"))
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

	@Test(priority = 3)
	public void WellVersedMethodUsingAjaxPageButtonUnapprovedScenario() throws Exception {

		driver.get(readconfig.getwellversedURL());

		driver.manage().window().maximize();

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(
				By.xpath("(//a[contains(@href,'electrolyte-powder-for-instant-energy-and-hydration')])[1]")));

		driver.findElement(By.cssSelector("button[id='add-to-cart']")).click();

		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='simpl_buynow-button'])[2]")));

		driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[2]")).click();

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id='simpl-checkout-iframe']")));

		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("phone-number")));

		driver.findElement(By.id("phone-number")).sendKeys(readconfig.getblockedMobNo());

		driver.findElement(By.cssSelector("button[data-cy=\"verify-mobile\"]")).click();
		
		driver.findElement(By.id("phone-number")).sendKeys(readconfig.getblockedMobNo());

		driver.findElement(By.cssSelector("button[data-cy=\"verify-mobile\"]")).click();
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[contains(text(),'UPI')]")));

		String simplPayLatertext = driver.findElement(By.xpath("//h5[contains(text(),'UPI')]")).getText();

		String buttontext = driver.findElement(By.xpath("//button[contains(text(),'CONTINUE TO PAY')]")).getText();

		Assert.assertEquals(simplPayLatertext, "UPI",
				"Simpl Pay Later text is present on the Tachyon Checkout Page");	

		System.out.println(buttontext);
		
		System.out.println("Simpl Pay Later text is not present on the Tachyon Checkout Page");

	}

	@Test(priority = 4)
	public void WellVersedMethodWrongOTPScenario() throws Exception {

		driver.get(readconfig.getwellversedURL());

		driver.manage().window().maximize();

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(
				By.xpath("(//a[contains(@href,'electrolyte-powder-for-instant-energy-and-hydration')])[1]")));

		driver.findElement(By.cssSelector("button[id='add-to-cart']")).click();

		new WebDriverWait(driver, Duration.ofSeconds(20))
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

}
