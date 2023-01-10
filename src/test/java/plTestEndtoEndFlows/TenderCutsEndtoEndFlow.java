package plTestEndtoEndFlows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commonMethods.BaseClass;
import commonMethods.ReadConfig;

public class TenderCutsEndtoEndFlow extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	ReadConfig readconfig = new ReadConfig();

	public Map<Integer, ArrayList<String>> TenderCutsSuccessTestCode() throws Exception {

		driver.get(readconfig.getTenderCutsURL());

		driver.manage().window().maximize();

		int pl_position = 0;

		int eventPositiononbtn = 0;

		String eventPositiononbtntext = null;

		ArrayList<String> dataList = new ArrayList<String>();

		Map<Integer, ArrayList<String>> dataValues = new HashMap<Integer, ArrayList<String>>();

		driver.findElement(By.id("login-button")).click();

		driver.findElement(By.cssSelector("input[id='phoneNumber']")).sendKeys(readconfig.getsuccessMobNo());

		driver.findElement(By.id("submit-OTP")).click();

		Thread.sleep(15000);

		wait.until(ExpectedConditions.elementToBeClickable(By.id("address-0")));

		driver.findElement(By.id("address-0")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("product-search")));

		driver.findElement(By.id("product-search")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='product-search-input']")));

		driver.findElement(By.cssSelector("input[id='product-search-input']")).sendKeys("Biryani");

		Thread.sleep(8000);

		Actions builder = new Actions(driver);

		Action mouseOverHome = builder
				.moveToElement(driver.findElement(By.xpath("(//button[contains(text(),'ADD TO CART')])[1]"))).click()
				.build();

		mouseOverHome.perform();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class=\"close-button\"]/i)[1]")));

		driver.findElement(By.xpath("(//div[@class=\"close-button\"]/i)[1]")).click();

		driver.findElement(By.id("cart-btn")).click();

		driver.findElement(By.xpath("(//button[@id='cart-checkout-btn'])[1]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'6 PM - 8 PM')]")));

		driver.findElement(By.xpath("//div[contains(text(),'6 PM - 8 PM')]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[id='confirm-btn']")));

		driver.findElement(By.cssSelector("button[id='confirm-btn']")).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("button[class='mat-raised-button mat-primary']")));

		Thread.sleep(10000);

		driver.findElement(By.cssSelector("button[class='mat-raised-button mat-primary']")).click();

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[id='v-pills-tab']>a")));
		
		Thread.sleep(5000);

		List<WebElement> payMethodList = driver.findElements(By.cssSelector("div[id='v-pills-tab']>a"));

		for (int i = 0; i < payMethodList.size(); i++) {

			String payMethodName = payMethodList.get(i).getText();

			pl_position = (i + 1);

			if (payMethodName.contains("Wallets")) {

				System.out.println("Pay Later Option is present on the No. " + (i + 1) + " position");

				String xpathactual = payMethodList.get(i).toString();

				String[] xpathact1 = xpathactual.split("css selector:");

				String xpathact2 = xpathact1[1].replace(">a]", ">a");

				String abc = xpathact2 + ":nth-child" + "(" + pl_position + ")";

				String abc1 = abc.replace(" ", "");

				WebElement element4 = driver.findElement(By.cssSelector(abc1));

				Thread.sleep(8000);

				element4.click();

				if (eventPositiononbtn == 0) {

					eventPositiononbtntext = "N";
				}

				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("(//div[@class='mat-radio-label-content'])[4]/div/p")));

				String actualtext = driver.findElement(By.xpath("(//div[@class='mat-radio-label-content'])[4]/div/p"))
						.getText();

				Assert.assertEquals(actualtext, "SIMPL", "Simpl Option is not present on the Payment Page");

				String text1 = actualtext + " Option is present on the Payment Page";

				String text2 = text1.toLowerCase();

				dataList.add(text2);

				dataList.add(eventPositiononbtntext);

				dataValues.put(pl_position, dataList);

				// print command that Simpl is present on the Big Basket- Web Application
				// Checkout Page for email shooting

			} else {

				System.out.println("Pay Later Option is not present on the No." + pl_position + " position");

				// print command that Simpl is not present on the Big Basket- Web Application
				// Checkout Page for email shooting

			}

		}

		return dataValues;

	}

}
