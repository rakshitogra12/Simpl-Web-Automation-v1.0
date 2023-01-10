package tachyonTestScripts;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadConfig;

public class FridoTestScript extends BaseClass {

	ReadConfig readconfig = new ReadConfig();

	@Test(priority = 1)
	public void FridoMethodUsingPDPPageButtonApprovedScenario() throws Exception {

		driver.get(readconfig.getfridoURL());

		driver.manage().window().maximize();

		WebElement element1 = driver.findElement(By.xpath("(//a[contains(@href,'/collections/bestseller')])[1]"));

		Actions builder = new Actions(driver);

		Action mouseOverHome1 = builder.moveToElement(element1).click().build();

		mouseOverHome1.perform();

		WebElement element2 = driver
				.findElement(By.xpath("(//a[contains(@href,'frido-ultimate-coccyx-seat-cushion')])[3]"));

		Action mouseOverHome2 = builder.moveToElement(element2).click().build();

		mouseOverHome2.perform();

		WebElement element3 = driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[1]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);

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

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[contains(text(),'Frido Ultimate Coccyx Seat Cushion')]")));

		String productTitle = driver
				.findElement(By.xpath("//div[contains(text(),'Frido Ultimate Coccyx Seat Cushion')]")).getText();

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
	public void FridoMethodUsingAjaxCartButtonApprovedScenario() throws Exception {

		driver.get(readconfig.getfridoURL());

		driver.manage().window().maximize();

		WebElement element1 = driver.findElement(By.xpath("(//a[contains(@href,'/collections/bestseller')])[1]"));

		Actions builder = new Actions(driver);

		Action mouseOverHome1 = builder.moveToElement(element1).click().build();

		mouseOverHome1.perform();

		WebElement element2 = driver
				.findElement(By.xpath("(//a[contains(@href,'frido-ultimate-coccyx-seat-cushion')])[3]"));

		Action mouseOverHome2 = builder.moveToElement(element2).click().build();

		mouseOverHome2.perform();

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")));

		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='simpl_buynow-button'])[1]")));

		WebElement element3 = driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[1]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id='simpl-checkout-iframe']")));

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(
				ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Enter Mobile Number')]")));

		String text1 = driver.findElement(By.xpath("//p[contains(text(),'Enter Mobile Number')]")).getText();

		String text2 = driver.findElement(By.cssSelector("div[data-cy=\"order-summmery\"]")).getText();

		System.out.println(text1);

		System.out.println(text2);

	}

	@Test(priority = 3)
	public void FridoMethodUsingPDPPageButtonUnapprovedScenario() throws Exception {

		driver.get(readconfig.getfridoURL());

		driver.manage().window().maximize();

		WebElement element1 = driver.findElement(By.xpath("(//a[contains(@href,'/collections/bestseller')])[1]"));

		Actions builder = new Actions(driver);

		Action mouseOverHome1 = builder.moveToElement(element1).click().build();

		mouseOverHome1.perform();

		WebElement element2 = driver
				.findElement(By.xpath("(//a[contains(@href,'frido-ultimate-coccyx-seat-cushion')])[3]"));

		Action mouseOverHome2 = builder.moveToElement(element2).click().build();

		mouseOverHome2.perform();

		driver.findElement(By.xpath("(//button[@id=\"simpl_buynow-button\"])[2]")).click();

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
	public void FridoMethodWrongOTPScenario() throws Exception {

		driver.get(readconfig.getfridoURL());

		driver.manage().window().maximize();

		WebElement element1 = driver.findElement(By.xpath("(//a[contains(@href,'/collections/bestseller')])[1]"));

		Actions builder = new Actions(driver);

		Action mouseOverHome1 = builder.moveToElement(element1).click().build();

		mouseOverHome1.perform();

		WebElement element2 = driver
				.findElement(By.xpath("(//a[contains(@href,'frido-ultimate-coccyx-seat-cushion')])[3]"));

		Action mouseOverHome2 = builder.moveToElement(element2).click().build();

		mouseOverHome2.perform();

		new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='simpl_buynow-button'])[1]")));
		
		WebElement element3 = driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[1]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);

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
