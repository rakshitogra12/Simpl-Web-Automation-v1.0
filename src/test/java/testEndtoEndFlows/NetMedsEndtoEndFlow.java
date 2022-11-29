package testEndtoEndFlows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import commonMethods.BaseClass;
import commonMethods.ReadConfig;

public class NetMedsEndtoEndFlow extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	ReadConfig readconfig = new ReadConfig();

	public Map<Integer, ArrayList<String>> NetMedsSuccessTestCode() throws Exception {

		driver.get(readconfig.getNetMedsURL());

		driver.manage().window().maximize();

		int pl_position = 0;

//		int eventPositiononbtn = 0;
//
//		String eventPositiononbtntext = null;
//
//		ArrayList<String> dataList = new ArrayList<String>();

		Map<Integer, ArrayList<String>> dataValues = new HashMap<Integer, ArrayList<String>>();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Sign in / Sign up')]")));

		driver.findElement(By.xpath("//a[contains(text(),'Sign in / Sign up')]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("loginfirst_mobileno")));

		driver.findElement(By.id("loginfirst_mobileno")).sendKeys(readconfig.getsuccessMobNo());

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-signpass']")));

		driver.findElement(By.xpath("//button[@class='btn-signpass']")).click();

		Thread.sleep(15000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'verify')]")));

		driver.findElement(By.xpath("//button[contains(text(),'verify')]")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='q']")));

		driver.findElement(By.xpath("//input[@name='q']"))
				.sendKeys("Accu-Chek Instant Glucometer with Free 10 Test Strips");

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='product-addtocart-button'])[1]")));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.xpath("(//button[@id='product-addtocart-button'])[1]")));

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#minicart_btn")));

		driver.findElement(By.cssSelector("div#minicart_btn")).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='btn-checkout btn btn_to_checkout']")));

		driver.findElement(By.xpath("//button[@class='btn-checkout btn btn_to_checkout']")).click();

		Thread.sleep(5000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'SELECT ADDRESS')])[1]")));

		driver.findElement(By.xpath("(//a[contains(text(),'SELECT ADDRESS')])[1]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='customeraddress']")));

		driver.findElement(By.cssSelector("input[name='customeraddress']")).click();

		wait.until(
				ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button[id='pay-button']"))));

		driver.findElement(By.cssSelector("button[id='pay-button']")).click();

		wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='paymentul']/li/div[1]")));

		List<WebElement> payMethodList = driver.findElements(By.xpath("//ul[@id='paymentul']/li/div[1]"));

		for (int i = 0; i < payMethodList.size(); i++) {

			String payMethodName = payMethodList.get(i).getAttribute("innerText");

			pl_position = (i + 1);

			if (payMethodName.contains("PAY LATER")) {

				System.out.println("Pay Later Option is present on the No. " + pl_position + " position");

//				String xpathactual = payMethodList.get(i).toString();
//
//				String[] xpathact1 = xpathactual.split("xpath:");
//
//				String xpathact2 = xpathact1[1].replace("[@class='title ng-star-inserted']]",
//						"[@class='title ng-star-inserted']");
//
//				String abc = "(" + xpathact2 + ")[" + pl_position + "]";
//
//				String abc1 = abc.replace(" ", "");
//
//				if (eventPositiononbtn == 0) {
//
//					eventPositiononbtntext = "N";
//				}
//
//				wait.until(ExpectedConditions.presenceOfElementLocated(
//						By.cssSelector("li[id='paylater']>div:nth-child(2)>div>div>div>div:nth-child(2)>div")));
//
//				String actualtext = driver
//						.findElement(
//								By.cssSelector("li[id='paylater']>div:nth-child(2)>div>div>div>div:nth-child(2)>div"))
//						.getText();
//
//				Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");
//
//				String text1 = actualtext + " Option is present on the Payment Page";
//				
//				String text2 = text1.toLowerCase();
//
//				dataList.add(text2);
//
//				dataList.add(eventPositiononbtntext);
//
//				dataValues.put(pl_position, dataList);

			}

			else {

				System.out.println("Pay Later Option is not present on the No." + pl_position + " position");

			}
		}

		return dataValues;

	}

}
