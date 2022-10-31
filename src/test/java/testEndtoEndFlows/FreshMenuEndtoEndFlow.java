package testEndtoEndFlows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commonMethods.BaseClass;
import commonMethods.ReadConfig;

public class FreshMenuEndtoEndFlow extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	ReadConfig readconfig = new ReadConfig();

	public Map<Integer, ArrayList<String>> freshMenuSuccessTestCode() throws Exception {

		driver.get(readconfig.getFreshMenuURL());

		driver.manage().window().maximize();

		int pl_position = 0;

		int eventPositiononbtn = 0;

		String eventPositiononbtntext = null;

		ArrayList<String> dataList = new ArrayList<String>();

		Map<Integer, ArrayList<String>> dataValues = new HashMap<Integer, ArrayList<String>>();

		Thread.sleep(15000);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.cssSelector("span[class='close']:nth-child(2)")));

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[ng-click=\"showSearch()\"]")));

		driver.findElement(By.cssSelector("a[ng-click=\"showSearch()\"]")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[placeholder=\"Search\"]")));

		driver.findElement(By.cssSelector("input[placeholder=\"Search\"]"))
				.sendKeys("Cheesy Farmers Delight Burger\n" + "");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-binding ng-scope'][1]")));

		driver.findElement(By.xpath("//div[@class='ng-binding ng-scope'][1]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'ADD ITEM')]")));

		driver.findElement(By.xpath("//button[contains(text(),'ADD ITEM')]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class=\"proceed\"]>button")));

		driver.findElement(By.cssSelector("div[class=\"proceed\"]>button")).click();

		driver.findElement(By.xpath("(//input[@name='email'])[4]")).sendKeys(readconfig.getsuccessMobNo());

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//button[contains(@class,'btn-submit-auth-modal')])[1]")));

		driver.findElement(By.xpath("(//button[contains(@class,'btn-submit-auth-modal')])[1]")).click();

		System.out.println("Code worked till here");

		Thread.sleep(15000);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='checkout-sign-in-form']/form/div[4]/div/button")));

		driver.findElement(By.xpath("//div[@class='checkout-sign-in-form']/form/div[4]/div/button")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("address-box-0")));

		driver.findElement(By.id("address-box-0")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'CONTINUE')])[4]")));

		driver.findElement(By.xpath("(//button[contains(text(),'CONTINUE')])[4]")).click();

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='payment-left']>div")));

		List<WebElement> payMethodList = driver.findElements(By.cssSelector("div[class='payment-left']>div"));

		Thread.sleep(5000);

		for (int i = 0; i < payMethodList.size(); i++) {

			String payMethodName = payMethodList.get(i).getText();

			pl_position = (i + 1);

			if (payMethodName.contains("Pay Later")) {

				System.out.println("Pay Later Option is present on the No. " + (i + 1) + " position");

				String xpathactual = payMethodList.get(i).toString();

				String[] xpathact1 = xpathactual.split("css selector:");

				String xpathact2 = xpathact1[1].replace(">div]", ">div");

				String abc = xpathact2 + ":nth-child" + "(" + pl_position + ")";

				String abc1 = abc.replace(" ", "");

				WebElement element4 = driver.findElement(By.cssSelector(abc1));

				wait.until(ExpectedConditions.elementToBeClickable(element4)).click();

				element4.click();

				if (eventPositiononbtn == 0) {

					eventPositiononbtntext = "NO";
				}

				wait.until(ExpectedConditions
						.presenceOfElementLocated(By.cssSelector("div[id='fmPAY_LATER']>div>div>div>span")));

				String actualtext = driver.findElement(By.cssSelector("div[id='fmPAY_LATER']>div>div>div>span"))
						.getText();

				Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");

				String text1 = actualtext + " Option is present on the Payment Page";

				String text2 = text1.strip().toLowerCase();

				dataList.add(text2);

				dataList.add(eventPositiononbtntext);

				dataValues.put(pl_position, dataList);

				// print command that Simpl is present on the Big Basket- Web Application
				// Checkout Page for email shooting

			}

			else {

				System.out.println("Pay Later Option is not present on the No." + pl_position + " position");
//
//				// print command that Simpl is not present on the Big Basket- Web Application
//				// Checkout Page for email shooting
//
			}

		}
		return dataValues;

	}

}
