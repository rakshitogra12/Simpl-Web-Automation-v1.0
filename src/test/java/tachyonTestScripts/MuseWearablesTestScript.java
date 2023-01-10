package tachyonTestScripts;

import java.io.File;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadConfig;

public class MuseWearablesTestScript extends BaseClass {

	ReadConfig readconfig = new ReadConfig();

	@Test(priority = 1)
	public void MuseWearablesMethodUsingPDPPageButtonApprovedScenario() throws Exception {

		driver.get(readconfig.getmuseWearablesURL());

		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//a[contains(text(),'Muse Watch')])[1]")).click();

		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.id("b_1658468328ef075bd2-3")));

		driver.findElement(By.id("b_1658468328ef075bd2-3")).click();

		driver.findElement(By.xpath("(//span[contains(text(),'Buy Now')])[1]")).click();

		try {

			if (driver.findElement(By.cssSelector("i[class='fa fa-info-circle']")).isDisplayed()) {

				System.out.println("Ticker Text is present hence screenshot will be taken for Pay-In-3 Popup");

				driver.findElement(By.cssSelector("i[class='fa fa-info-circle']")).click();

				TakesScreenshot screenshot = (TakesScreenshot) driver;

				File src = screenshot.getScreenshotAs(OutputType.FILE);

				FileUtils.copyFile(src, new File(
						"/Users/rakshitogra/eclipse-workspace/Simpl-Web-Automation-v1.0/src/test/resources/Screenshots1/"
								+ "TickerText.png"));

				new WebDriverWait(driver, Duration.ofSeconds(20))
						.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("simpl-payin3-dynamic-popup"));

				driver.findElement(By.cssSelector("img[id='close_icon']")).click();

				driver.switchTo().defaultContent();

			} else {

				System.out.println("Ticker Text is present but not displayed because of some error");

			}
		} catch (Exception e) {

			System.out.println(
					"Ticker Text is not present, hence Tachyon Checkout Page functionality will not be executed");
		}

		try {

			if (driver.findElement(By.xpath("(//button[@id=\"simpl_buynow-button\"])[2]")).isDisplayed()) {

				System.out.println("Simpl Button is getting displayed.");

				driver.findElement(By.xpath("(//button[@id=\"simpl_buynow-button\"])[2]")).click();

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

				new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//div[contains(text(),'Flip Flops Store sale only')]")));

				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//h5[contains(text(),'Simpl Pay Later')]")));

				String simplPayLatertext = driver.findElement(By.xpath("//h5[contains(text(),'Simpl Pay Later')]"))
						.getText();

				String paylatertext = driver.findElement(By.id("PAY_LATER-payment-cta")).getText();

				Assert.assertEquals(simplPayLatertext, "Simpl Pay Later",
						"Simpl Pay Later text is not present on the Tachyon Checkout Page");

				Assert.assertEquals(paylatertext, "BUY NOW AND PAY LATER",
						"Pay Later payment option is not present on the Tachyon Checkout Page");

				if (driver.findElement(By.cssSelector("img[alt=\"close\"]")).isDisplayed()) {

					System.out.println("Close button is working as expected");

				}

				driver.findElement(By.cssSelector("img[alt=\"close\"]")).click();

				driver.findElement(By.xpath("//button[contains(text(),'CANCEL ORDER')]")).click();

			}

			else {

				System.out.println("Simpl Button is not getting displayed.");
			}
		} catch (Exception e) {

			System.out.println(
					"Simpl button is not present, hence Tachyon Checkout Page functionality will not be executed");

		}

	}

	@Test(priority = 2)
	public void MuseWearablesMethodUsingAjaxCartButtonApprovedScenario() throws Exception {

		driver.get(readconfig.getmuseWearablesURL());

		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//a[contains(text(),'Muse Watch')])[1]")).click();

		driver.findElement(By.id("b_1658468328ef075bd2-3")).click();

		driver.findElement(By.xpath("(//span[contains(text(),'Buy Now')])[1]")).click();

		driver.findElement(By.cssSelector("button[name='add']")).click();

		try {

			if (driver.findElement(By.xpath("(//button[@id=\"simpl_buynow-button\"])[2]")).isDisplayed()) {

				System.out.println("Tachyon CTA Button is visible and working");

				driver.findElement(By.xpath("(//button[@id=\"simpl_buynow-button\"])[2]")).click();

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

				driver.findElement(By.xpath("(//button[@id=\"simpl_buynow-button\"])[2]")).click();

				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
						.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id='simpl-checkout-iframe']")));

				driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id='simpl-checkout-iframe']")));

				System.out.println("Tachyon Checkout Page is getting loaded as expected");

				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//p[contains(text(),'Enter Mobile Number')]")));

				String text1 = driver.findElement(By.xpath("//p[contains(text(),'Enter Mobile Number')]")).getText();

				String text2 = driver.findElement(By.cssSelector("div[data-cy=\"order-summmery\"]")).getText();

				System.out.println(text1);

				System.out.println(text2);

			} else {
				System.out.println("Tachyon CTA Button is not getting displayed.");

			}

		} catch (Exception e) {

		}
		System.out.println(
				"Tachyon CTA Button is not getting displayed, hence Tachyon Checkout Page functionality will not be executed");

	}

	@Test(priority = 3)
	public void MuseWearablesMethodUsingPDPPageButtonUnapprovedScenario() throws Exception {

		driver.get(readconfig.getmuseWearablesURL());

		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//a[contains(text(),'Muse Watch')])[1]")).click();

		driver.findElement(By.id("b_1658468328ef075bd2-3")).click();

		driver.findElement(By.xpath("(//span[contains(text(),'Buy Now')])[1]")).click();

		try {

			if (driver.findElement(By.xpath("(//button[@id=\"simpl_buynow-button\"])[2]")).isDisplayed()) {

				System.out.println("Tachyon CTA Button is visible");

				driver.findElement(By.xpath("(//button[@id=\"simpl_buynow-button\"])[2]")).click();

				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
						.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id='simpl-checkout-iframe']")));

				driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id='simpl-checkout-iframe']")));

				System.out.println("Tachyon Checkout Page is getting loaded as expected");

				new WebDriverWait(driver, Duration.ofSeconds(10))
						.until(ExpectedConditions.presenceOfElementLocated(By.id("phone-number")));

				driver.findElement(By.id("phone-number")).sendKeys(readconfig.getblockedMobNo());

				driver.findElement(By.cssSelector("button[data-cy=\"verify-mobile\"]")).click();

				new WebDriverWait(driver, Duration.ofSeconds(10))
						.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[contains(text(),'UPI')]")));

				String simplPayLatertext = driver.findElement(By.xpath("//h5[contains(text(),'UPI')]")).getText();

				String buttontext = driver.findElement(By.xpath("//button[contains(text(),'CONTINUE TO PAY')]"))
						.getText();

				Assert.assertEquals(simplPayLatertext, "UPI",
						"Simpl Pay Later text is present on the Tachyon Checkout Page");

				System.out.println(buttontext);

				System.out.println("Simpl Pay Later text is not present on the Tachyon Checkout Page");

			} else {
				System.out.println("Tachyon CTA Button is not getting displayed");

			}

		} catch (Exception e) {

			System.out.println(
					"Tachyon CTA Button is not getting displayed, hence Tachyon Checkout Page functionality will not be executed");

		}

	}

	@Test(priority = 4)
	public void MuseWearablesMethodWrongOTPScenario() throws Exception {

		driver.get(readconfig.getmuseWearablesURL());

		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//a[contains(text(),'Muse Watch')])[1]")).click();

		driver.findElement(By.id("b_1658468328ef075bd2-3")).click();

		driver.findElement(By.xpath("(//span[contains(text(),'Buy Now')])[1]")).click();

		try {

			if (driver.findElement(By.xpath("(//button[@id=\"simpl_buynow-button\"])[2]")).isDisplayed()) {

				System.out.println("Tachyon CTA Button is visible");

				driver.findElement(By.xpath("(//button[@id=\"simpl_buynow-button\"])[2]")).click();

				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
						.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id='simpl-checkout-iframe']")));

				driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id='simpl-checkout-iframe']")));

				System.out.println("Tachyon Checkout Page is getting loaded as expected");

				driver.findElement(By.id("phone-number")).sendKeys(readconfig.getsuccessMobNo());

				driver.findElement(By.cssSelector("button[data-cy=\"verify-mobile\"]")).click();

				Thread.sleep(10000);

				String otpText = driver.findElement(By.cssSelector("span[data-cy=\"otp-error\"]")).getText();

				Assert.assertEquals(otpText, "Invalid OTP", "Invalid OTP text is not present on the OTP Page");

				System.out.println("Invalid OTP text is present on the OTP Page");

			} else {

				System.out.println("Tachyon CTA Button is not getting displayed");

			}

		} catch (Exception e) {

			System.out.println(
					"Tachyon CTA Button is not getting displayed, hence Tachyon Checkout Page functionality will not be executed");

		}

	}

	@Test(priority = 5)
	public void MuseWearablesaMethodPriceComparisonScenario() throws Exception {

		driver.get(readconfig.getmuseWearablesURL());

		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//a[contains(text(),'Muse Watch')])[1]")).click();

		driver.findElement(By.id("b_1658468328ef075bd2-3")).click();

		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Buy Now')])[4]")));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.xpath("(//span[contains(text(),'Buy Now')])[4]")));

		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[name='add']")));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.cssSelector("button[name='add']")));

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//a[contains(text(),'Muse Modernist')]")));

		String productTitle_ViewCart = driver
				.findElement(By.xpath("//a[contains(text(),'Muse Modernist')]")).getText();
		
		String qtyText_ViewCart = "Qty: "
				+ driver.findElement(By.id("miniupdates_42195761135774:b702c1c0a4fd39df8135040cefc4cdba")).getAttribute("value");

		String subTotalPrice__ViewCart = driver.findElement(By.xpath("(//span[@class='money bacurr-money'])[5]")).getText();

		driver.findElement(By.xpath("div[title='Add A Coupon']")).click();
		
		driver.findElement(By.id("CartDiscountcode")).sendKeys("WELCOME10");
		
		driver.findElement(By.xpath("(//button[contains(text(),'Save')])[2]")).click();

		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p[id='CartTotal']>strong")));

		String totalPrice_ViewCart = driver.findElement(By.cssSelector("p[id='CartTotal']>strong")).getText();

		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='simpl_buynow-button'])[1]")));

		try {

			if (driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[1]")).isDisplayed()) {

				System.out.println("Tachyon CTA Button is visible");

				driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[1]")).click();

				new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
						.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id='simpl-checkout-iframe']")));

				new WebDriverWait(driver, Duration.ofSeconds(20))
						.until(ExpectedConditions.elementToBeClickable(By.id("phone-number")));

				driver.findElement(By.id("phone-number")).sendKeys(readconfig.getsuccessMobNo());

				driver.findElement(By.cssSelector("button[data-cy=\"verify-mobile\"]")).click();

				new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Simpl exclusive discount')]")));

				driver.findElement(By.xpath("//p[contains(text(),'Details')]")).click();

				new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.stalenessOf(
						driver.findElement(By.xpath("//div[contains(text(),'Flip Flops Store sale only')]"))));

				String productTitle_TachyonCheckout = driver
						.findElement(By.xpath("//div[contains(text(),'Flip Flops Store sale only')]")).getText();

				String qtyText_TachyonCheckout = driver.findElement(By.xpath("//span[contains(text(),'Qty')]"))
						.getText();

				driver.findElement(By.cssSelector("input[id='coupon']")).sendKeys("FIRST");

				driver.findElement(By.xpath("//button[contains(text(),'APPLY')]")).click();

				Thread.sleep(5000);

				String subTotalPrice_TachyonCheckout = driver
						.findElement(By.xpath("(//div[contains(@class,'item svelte-3in6d6')])[1]/span[2]")).getText();

				String coupondiscountPrice_TachyonCheckout = driver
						.findElement(By.xpath("(//div[contains(@class,'item svelte-3in6d6')])[2]/span[2]")).getText();

				Thread.sleep(5000);

				String simpldiscountPrice_TachyonCheckout = driver
						.findElement(By.xpath("(//div[contains(@class,'item svelte-3in6d6')])[4]/span[2]")).getText();

				String totalPrice_TachyonCheckout = driver
						.findElement(By.xpath("//div[@data-cy='order-detail-price']/span[2]")).getText();

				System.out.println(productTitle_ViewCart);

				System.out.println(qtyText_ViewCart);

				System.out.println(totalPrice_ViewCart);

				if (subTotalPrice__ViewCart.equals(totalPrice_ViewCart)) {

					System.out.println("No Discount is applied on the View Cart page");

				} else {

					System.out.println("A Discount is applied on the View Cart page");

				}

				System.out.println(productTitle_TachyonCheckout);

				System.out.println(qtyText_TachyonCheckout);

				System.out.println(subTotalPrice_TachyonCheckout);

				System.out.println(coupondiscountPrice_TachyonCheckout);

				System.out.println(simpldiscountPrice_TachyonCheckout);

				System.out.println(totalPrice_TachyonCheckout);

				if (subTotalPrice_TachyonCheckout.equals(totalPrice_TachyonCheckout)) {

					System.out.println("No Discount is applied on the Tachyon Checkout Page");

				} else {

					System.out.println("Discount(s) is applied on the Tachyon Checkout Page");

				}

			} else {

				System.out.println("Tachyon CTA Button is not getting displayed");

			}

		} catch (Exception e) {

			System.out.println(
					"Tachyon CTA Button is not getting displayed, hence Tachyon Checkout Page functionality will not be executed");

		}

	}

}