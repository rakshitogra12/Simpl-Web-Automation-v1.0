package tachyonTestScripts_MWeb;

import commonMethods.BaseClass;
import commonMethods.ReadConfig;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UrbanPitaraTestScript extends BaseClass {

	ReadConfig readconfig = new ReadConfig();

	@Test(priority = 1)
	public void UrbanPitaraMethodUsingPDPPageButtonApprovedScenario() throws Exception {

		Map<String, String> mobileEmulation = new HashMap<>();

		mobileEmulation.put("deviceName", "Nexus 5");

		ChromeOptions chromeOptions = new ChromeOptions();

		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.get(readconfig.geturbanPitaraURL());

		driver.findElement(By.cssSelector("span[class='sidebar__menu-handle']")).click();

		driver.findElement(By.xpath("(//span[contains(text(),'Shoes')])[1]")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Flip Flops Store sale only')]")).click();

		try {

			if (driver.findElement(By.xpath("(//button[@id='simpl_buynow-button'])[2]")).isDisplayed()) {

				System.out.println("Simpl Button is getting displayed.");

				driver.findElement(By.xpath("(//*[@id='simpl_buynow-button'])[2]")).click();

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

				Thread.sleep(6000);

				String productTitle = driver
						.findElement(By.xpath("//div[contains(text(),'Flip Flops Store sale only')]")).getText();

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

				Assert.assertEquals(paylatertext, "SWIPE TO ORDER",
						"Pay Later payment option is not present on the Tachyon Checkout Page");

				System.out.println("Simpl Pay Later text is  present on the Tachyon Checkout Page");

				System.out.println(productTitle);

				System.out.println(qtyText);

				System.out.println(cartPrice);

				if (driver.findElement(By.cssSelector("img[alt='close']")).isDisplayed()) {

					System.out.println("Close button is working as expected");

				}

				driver.findElement(By.cssSelector("img[alt='close']")).click();

				new WebDriverWait(driver, Duration.ofSeconds(20)).until(
						ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'CANCEL ORDER')]")));

				((JavascriptExecutor) driver).executeScript("arguments[0].click();",

						driver.findElement(By.xpath("//button[contains(text(),'CANCEL ORDER')]")));

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

		Map<String, String> mobileEmulation = new HashMap<>();

		mobileEmulation.put("deviceName", "Nexus 5");

		ChromeOptions chromeOptions = new ChromeOptions();

		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.get(readconfig.geturbanPitaraURL());

		driver.findElement(By.cssSelector("span[class='sidebar__menu-handle']")).click();

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

		Map<String, String> mobileEmulation = new HashMap<>();

		mobileEmulation.put("deviceName", "Nexus 5");

		ChromeOptions chromeOptions = new ChromeOptions();

		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.get(readconfig.geturbanPitaraURL());

		driver.findElement(By.cssSelector("span[class='sidebar__menu-handle']")).click();

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

		Map<String, String> mobileEmulation = new HashMap<>();

		mobileEmulation.put("deviceName", "Nexus 5");

		ChromeOptions chromeOptions = new ChromeOptions();

		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.get(readconfig.geturbanPitaraURL());

		driver.findElement(By.cssSelector("span[class='sidebar__menu-handle']")).click();

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

		Map<String, String> mobileEmulation = new HashMap<>();

		mobileEmulation.put("deviceName", "Nexus 5");

		ChromeOptions chromeOptions = new ChromeOptions();

		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.get(readconfig.geturbanPitaraURL());

		driver.findElement(By.cssSelector("span[class='sidebar__menu-handle']")).click();

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

}