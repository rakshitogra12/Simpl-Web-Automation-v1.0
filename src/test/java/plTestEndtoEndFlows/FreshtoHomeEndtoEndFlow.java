package plTestEndtoEndFlows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import commonMethods.BaseClass;
import commonMethods.ReadConfig;

public class FreshtoHomeEndtoEndFlow extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	ReadConfig readconfig = new ReadConfig();

	public Map<Integer, ArrayList<String>> FreshtoHomeSuccessTestCode() throws Exception {

		driver.get(readconfig.getfreshtoHomeURL());

		driver.manage().window().maximize();

		int pl_position = 0;

		String eventPositiononbtntext = null;

		ArrayList<String> dataList = new ArrayList<String>();

		Map<Integer, ArrayList<String>> dataValues = new HashMap<Integer, ArrayList<String>>();

		driver.findElement(By.id("autoComplete")).sendKeys("411015");

		driver.findElement(By.id("autoComplete")).sendKeys(Keys.ENTER);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title=\"Login\"]")));

		driver.findElement(By.cssSelector("a[title=\"Login\"]")).click();

		driver.findElement(By.cssSelector("#youama-phone")).sendKeys(readconfig.getsuccessMobNo());

		driver.findElement(By.id("sendOtpBtn")).click();

		Thread.sleep(15000);

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//div[@class='youama-window-inside'])[2]/div[4]/div/button[2]")))
				.click();

		Thread.sleep(10000);

		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.cssSelector("form[id='search_mini_form']>div>input")));

		driver.findElement(By.cssSelector("form[id='search_mini_form']>div>input")).sendKeys("Spicy Chicken Salami (200g)");

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Search']")));

		driver.findElement(By.cssSelector("button[title='Search']")).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//a[contains(@href,'spicy-chicken-salami-200g')]")));

		driver.findElement(By.xpath("//a[contains(@href,'spicy-chicken-salami-200g')]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='button btn-cart']")));

		driver.findElement(By.cssSelector("button[class='button btn-cart']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class=\"menu-cart-icon\"]")));

		driver.findElement(By.cssSelector("div[class=\"menu-cart-icon\"]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Checkout')]")));

		driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Continue']")));

		driver.findElement(By.cssSelector("button[title='Continue']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class=\"button btn-checkout\"]")));

		driver.findElement(By.cssSelector("button[class=\"button btn-checkout\"]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("pay-online")));

		driver.findElement(By.id("pay-online")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Place Order')]")));

		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("razorpay-checkout-frame")));

		wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'svelte-2ktngz')]/button")));

		wait.until(ExpectedConditions
				.stalenessOf(driver.findElement(By.xpath("//div[contains(@class,'svelte-2ktngz')]/button"))));

		List<WebElement> payMethodList = driver
				.findElements(By.xpath("//div[contains(@class,'svelte-2ktngz')]/button"));

		for (int i = 0; i < payMethodList.size(); i++) {

			String payMethodName = payMethodList.get(i).getText();

			pl_position = (i + 1);

			if (payMethodName.contains("Pay Later")) {

				System.out.println("Pay Later Option is present on the No. " + (i + 1) + " position");

				String xpathactual = payMethodList.get(i).toString();

				String[] xpathact1 = xpathactual.split("xpath:");

				String xpathact2 = xpathact1[1].replaceAll("/button]", "/button");

				String abc = "(" + xpathact2 + ")[" + pl_position + "]";

				String abc1 = abc.replace(" ", "");

				WebElement element4 = driver.findElement(By.xpath(abc1));

				Thread.sleep(5000);

				Actions builder = new Actions(driver);

				Action mouseOverHome = builder.moveToElement(element4).click().build();

				mouseOverHome.perform();

				if (driver.findElement(By.cssSelector("div[data-paylater='getsimpl']>div:nth-child(2)")).isEnabled()) {

					eventPositiononbtntext = "Y";
				}

				wait.until(ExpectedConditions
						.presenceOfElementLocated(By.cssSelector("div[data-paylater=\"getsimpl\"]>div:nth-child(2)")));

				String actualtext = driver
						.findElement(By.cssSelector("div[data-paylater=\"getsimpl\"]>div:nth-child(2)")).getText();

				Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");

				driver.findElement(By.xpath("(//div[contains(text(),'Simpl')])[2]")).click();

				String text1 = actualtext + " Option is present on the Payment Page";

				String text2 = text1.strip().toLowerCase();

				dataList.add(text2);

				dataList.add(eventPositiononbtntext);

				dataValues.put(pl_position, dataList);

			}

			else {

				System.out.println("Pay Later Option is not present on the No." + pl_position + " position");

			}

		}

		return dataValues;
	}

}
