package tachyonTestScripts;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import commonMethods.BaseClass;
import commonMethods.ReadConfig;
import commonMethods.Read_Write_Excel_Tachyon;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WindowType;

public class UrbanPitaraTestScript extends BaseClass {

	ReadConfig readconfig = new ReadConfig();

	@Test(priority = 1)
	public void UrbanPitaraMethodUsingPDPPageButtonApprovedScenario() throws Exception {

		String merchantName = "UrbanPitara";

		driver.get(readconfig.geturbanPitaraURL());

		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//span[contains(text(),'Shoes')])[1]")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Flip Flops Store sale only')]")).click();

		try {

			if (driver.findElement(By.cssSelector("i[class='fa fa-info-circle']")).isDisplayed()) {

				System.out.println("Ticker Text is present hence screenshot will be taken for Pay-In-3 Popup");

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

			} else {

				System.out.println("Ticker Text is present but not displayed because of some error");

			}
		} catch (Exception e) {

			System.out.println(
					"Ticker Text is not present, hence Tachyon Checkout Page functionality will not be executed");
		}

		try {

			if (driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[2]")).isDisplayed()) {

				System.out.println("Simpl Button is getting displayed.");

				driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[2]")).click();

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
						.presenceOfElementLocated(By.xpath("//div[contains(text(),'Flip Flops Store sale only')]")));

				String productTitle = driver
						.findElement(By.xpath("//div[contains(text(),'Flip Flops Store sale only')]")).getText();

				Thread.sleep(5000);

				String qtyText = driver.findElement(By.xpath("//span[contains(text(),'Qty')]")).getText();

				String cartPrice = driver.findElement(By.xpath("//div[@data-cy='order-detail-price']/span[2]"))
						.getText();

				driver.findElement(By.cssSelector("input[id='coupon']")).sendKeys("FIRST");

				driver.findElement(By.xpath("//button[contains(text(),'APPLY')]")).click();

				new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//h5[contains(text(),'Simpl Pay Later')]")));

				String simplPayLatertext = driver.findElement(By.xpath("//h5[contains(text(),'Simpl Pay Later')]"))
						.getText();

				String paylatertext = driver.findElement(By.id("PAY_LATER-payment-cta")).getText();

				Assert.assertEquals(simplPayLatertext, "Simpl Pay Later",
						"Simpl Pay Later text is not present on the Tachyon Checkout Page");

				Assert.assertEquals(paylatertext, "BUY NOW AND PAY LATER",
						"Pay Later payment option is not present on the Tachyon Checkout Page");

				System.out.println("Simpl Pay Later text is present on the Tachyon Checkout Page");

				System.out.println(productTitle);

				System.out.println(qtyText);

				System.out.println(cartPrice);

				if (driver.findElement(By.cssSelector("img[alt=\"close\"]")).isDisplayed()) {

					System.out.println("Close button is working as expected");

				}

				driver.findElement(By.cssSelector("img[alt=\"close\"]")).click();

				((JavascriptExecutor) driver).executeScript("arguments[0].click();",
						driver.findElement(By.cssSelector("input[id=\"signinVerify\"]")));

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
	public void UrbanPitaraMethodUsingAjaxCartButtonApprovedScenario() throws Exception {

		driver.get(readconfig.geturbanPitaraURL());

		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//span[contains(text(),'Shoes')])[1]")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Flip Flops Store sale only')]")).click();

		driver.findElement(By.cssSelector("button[name=\"add\"]")).click();

		try {

			if (driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[2]")).isDisplayed()) {

				System.out.println("Simpl Button is getting displayed.");

				driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[2]")).click();

				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
						.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id='simpl-checkout-iframe']")));

				new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//p[contains(text(),'Enter Mobile Number')]")));

				String text1 = driver.findElement(By.xpath("//p[contains(text(),'Enter Mobile Number')]")).getText();

				String text2 = driver.findElement(By.cssSelector("div[data-cy=\"order-summmery\"]")).getText();

				System.out.println(text1);

				System.out.println(text2);

				System.out.println("Tachyon Checkout Iframe is getting displayed.");

			} else {

				System.out.println("Tachyon CTA Button is not getting displayed.");

			}

		} catch (Exception e) {

			System.out.println(
					"Tachyon CTA Button is not getting displayed, hence Tachyon Checkout Page functionality will not be executed");

		}

	}

	@Test(priority = 3)
	public void UrbanPitaraMethodUsingPDPPageButtonUnapprovedScenario() throws Exception {

		driver.get(readconfig.geturbanPitaraURL());

		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//span[contains(text(),'Shoes')])[1]")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Flip Flops Store sale only')]")).click();

		try {

			if (driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[2]")).isDisplayed()) {

				System.out.println("Tachyon CTA Button is visible");

				driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[2]")).click();

				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
						.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id='simpl-checkout-iframe']")));

				new WebDriverWait(driver, Duration.ofSeconds(20))
						.until(ExpectedConditions.presenceOfElementLocated(By.id("phone-number")));

				driver.findElement(By.id("phone-number")).sendKeys(readconfig.getblockedMobNo());

				driver.findElement(By.cssSelector("button[data-cy=\"verify-mobile\"]")).click();

				Thread.sleep(15000);

				new WebDriverWait(driver, Duration.ofSeconds(10))
						.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[contains(text(),'UPI')]")));

				String simplPayLatertext = driver.findElement(By.xpath("//h5[contains(text(),'UPI')]")).getText();

				Assert.assertEquals(simplPayLatertext, "UPI",
						"Simpl Pay Later text is present on the Tachyon Checkout Page");

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
	public void UrbanPitaraMethodWrongOTPScenario() throws Exception {

		driver.get(readconfig.geturbanPitaraURL());

		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//span[contains(text(),'Shoes')])[1]")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Flip Flops Store sale only')]")).click();

		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='simpl_buynow-button'])[2]")));

		try {

			if (driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[2]")).isDisplayed()) {

				System.out.println("Tachyon CTA Button is visible");

				driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[2]")).click();

				new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
						.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id='simpl-checkout-iframe']")));

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

				driver.findElement(By.id("phone-number")).sendKeys(readconfig.getsuccessMobNo());

				driver.findElement(By.cssSelector("button[data-cy=\"verify-mobile\"]")).click();

				driver.findElement(By.cssSelector("input[id='otp']")).sendKeys("0000");

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
	public void UrbanPitaraMethodPriceComparisonScenario() throws Exception {

		driver.get(readconfig.geturbanPitaraURL());

		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//span[contains(text(),'Shoes')])[1]")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Flip Flops Store sale only')]")).click();

		driver.findElement(By.cssSelector("button[name='add']")).click();

		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("a[id='ViewCart']"))));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.cssSelector("a[id='ViewCart']")));

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//a[contains(text(),'Flip Flops Store sale only')]")));

		String productTitle_ViewCart = driver
				.findElement(By.xpath("//a[contains(text(),'Flip Flops Store sale only')]")).getText();

		String productTitle_ViewCart1 = productTitle_ViewCart.replace("(Male / 6 UK)", "");

		String qtyText_ViewCart = "Qty: "
				+ driver.findElement(By.cssSelector("input[id='updates_41743449981104']")).getAttribute("value");

		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='price']>div>strong")));

		String subTotalPrice__ViewCart = driver.findElement(By.cssSelector("div[class='price']>div>strong")).getText();

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

				System.out.println(productTitle_ViewCart1);

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

	@Test(priority = 6)
	public void UrbanPitaraMethodCTAButtonStatusCheck() throws Exception {

		String merchantName = "Urban Pitara";

		String ctaBtnStatus_PDP = null;

		String ctaBtnStatus_Ajax = null;

		String ctaBtnStatus_Cart = null;

		ArrayList<String> statusList = new ArrayList<String>();

		driver.get(readconfig.geturbanPitaraURL());

		driver.manage().window().maximize();

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.cssSelector("div[id='mypopup']>span")));
		
		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[id='cmessage_form_iframe']")));
				
		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='close_icon']")));

		driver.findElement(By.xpath("//div[@class='close_icon']")).click();
		
		driver.switchTo().defaultContent();
		
		new WebDriverWait(driver, Duration.ofSeconds(20))
		.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='loox-pn-close']")));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.cssSelector("a[class='loox-pn-close']")));
				
		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Shoes')])[1]")));

		driver.findElement(By.xpath("(//span[contains(text(),'Shoes')])[1]")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Flip Flops Store sale only')]")).click();

		if (driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[2]")).isDisplayed()) {

			System.out.println("Tachyon CTA Button is getting displayed on PDP Page");

			ctaBtnStatus_PDP = "PASS";

		} else {

			System.out.println("Tachyon CTA Button is not getting displayed on PDP Page");

			ctaBtnStatus_PDP = "FAIL";

		}

		statusList.add(ctaBtnStatus_PDP);

		driver.findElement(By.cssSelector("button[name=\"add\"]")).click();

		if (driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[2]")).isDisplayed()) {

			System.out.println("Tachyon CTA Button is getting displayed on Ajax Cart Page");

			ctaBtnStatus_Ajax = "PASS";

		} else {

			System.out.println("Tachyon CTA Button is not getting displayed on Ajax Page");

			ctaBtnStatus_Ajax = "FAIL";

		}

		statusList.add(ctaBtnStatus_Ajax);

		Thread.sleep(6000);

		driver.switchTo().newWindow(WindowType.TAB);

		driver.get("https://urbanpitara.com/cart");

		if (driver.findElement(By.xpath("//button[@id='simpl_buynow-button']")).isDisplayed()) {

			System.out.println("Tachyon CTA Button is getting displayed on View Cart Page");

			ctaBtnStatus_Cart = "PASS";

		} else {

			System.out.println("Tachyon CTA Button is not getting displayed on View Cart Page");

			ctaBtnStatus_Cart = "FAIL";

		}

		statusList.add(ctaBtnStatus_Cart);

		Read_Write_Excel_Tachyon obj = new Read_Write_Excel_Tachyon();

		obj.ReadExcelLoginMethodStatusCheck(statusList, merchantName);

	}

	@Test(priority = 7)
	public void UrbanPitaraMethodCTAButtonTextCapturing() throws Exception {

		String merchantName = "Urban Pitara";

		String ctaBtnText_PDP = null;

		String ctaBtnText_Ajax = null;

		String ctaBtnText_Cart = null;

		ArrayList<String> textList = new ArrayList<String>();

		driver.get(readconfig.geturbanPitaraURL());

		driver.manage().window().maximize();

		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Shoes')])[1]")));

		driver.findElement(By.xpath("(//span[contains(text(),'Shoes')])[1]")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Flip Flops Store sale only')]")).click();

		if (driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[2]")).isDisplayed()) {

			ctaBtnText_PDP = (driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[2]")).getText());

		} else {

			System.out.println("Tachyon CTA Button is not getting displayed on PDP Page");

		}

		textList.add(ctaBtnText_PDP);

		driver.findElement(By.cssSelector("button[name=\"add\"]")).click();

		if (driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[2]")).isDisplayed()) {

			ctaBtnText_Ajax = (driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[2]")).getText());

		} else {

			System.out.println("Tachyon CTA Button is not getting displayed on Ajax Page");

		}

		textList.add(ctaBtnText_Ajax);

		Thread.sleep(6000);

		driver.switchTo().newWindow(WindowType.TAB);

		driver.get("https://urbanpitara.com/cart");

		if (driver.findElement(By.xpath("//button[@id='simpl_buynow-button']")).isDisplayed()) {

			ctaBtnText_Cart = (driver.findElement(By.xpath("//button[@id='simpl_buynow-button']")).getText());

			System.out.println("Tachyon CTA Button is getting displayed on View Cart Page");

		} else {

			System.out.println("Tachyon CTA Button is not getting displayed on View Cart Page");

		}

		textList.add(ctaBtnText_Cart);

		Read_Write_Excel_Tachyon obj = new Read_Write_Excel_Tachyon();

		obj.ReadExcelLoginMethodTextCapturing(textList, merchantName);

	}

}
