package testEndtoEndFlows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import commonMethods.BaseClass;
import commonMethods.ReadConfig;
import pageObjectFiles.Tata1MGFlowElements;

import org.testng.Assert;

public class Tata1MGEndtoEndFlow extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	ReadConfig readconfig = new ReadConfig();

	public Map<Integer, ArrayList<String>> tata1MGSuccessTestCode() throws Exception {

		driver.get(readconfig.getTata1MGURL());

		driver.findElement(By.cssSelector(Tata1MGFlowElements.minimizebtn)).click();

		driver.manage().window().maximize();

		int pl_position = 0;

		int eventPositiononbtn = 0;

		String eventPositiononbtntext = null;

		ArrayList<String> dataList = new ArrayList<String>();

		Map<Integer, ArrayList<String>> dataValues = new HashMap<Integer, ArrayList<String>>();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Tata1MGFlowElements.loginLink)));

		driver.findElement(By.xpath(Tata1MGFlowElements.loginLink)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Tata1MGFlowElements.UserNotextbox)));

		driver.findElement(By.xpath(Tata1MGFlowElements.UserNotextbox)).sendKeys(readconfig.getsuccessMobNo());

		driver.findElement(By.xpath(Tata1MGFlowElements.continuebtn)).click();

		Thread.sleep(15000);

		driver.findElement(By.xpath(Tata1MGFlowElements.continuebtn)).click();

		Thread.sleep(10000);

		driver.findElement(By.id(Tata1MGFlowElements.searchbar))
				.sendKeys("HealthVit Cenvitan Women Multivitamin & Multimineral Tablet");

		driver.findElement(By.xpath(Tata1MGFlowElements.searchbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Tata1MGFlowElements.addbtn)));

		driver.findElement(By.xpath(Tata1MGFlowElements.addbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Tata1MGFlowElements.cartbtn)));

		driver.findElement(By.xpath(Tata1MGFlowElements.cartbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Tata1MGFlowElements.btn)));

		driver.findElement(By.xpath(Tata1MGFlowElements.btn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Tata1MGFlowElements.proceedBtn)));

		driver.findElement(By.xpath(Tata1MGFlowElements.proceedBtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Tata1MGFlowElements.tommorowbtn)));

		driver.findElement(By.xpath(Tata1MGFlowElements.tommorowbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Tata1MGFlowElements.addressproceedlink)));

		driver.findElement(By.xpath(Tata1MGFlowElements.addressproceedlink)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Tata1MGFlowElements.summarypagebtn)));

		driver.findElement(By.xpath(Tata1MGFlowElements.summarypagebtn)).click();

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(Tata1MGFlowElements.elementsList)));

		List<WebElement> payMethodList = driver.findElements(By.xpath(Tata1MGFlowElements.elementsList));

		Thread.sleep(5000);

		for (int i = 0; i < payMethodList.size(); i++) {

			String payMethodName = payMethodList.get(i).getText();

			pl_position = (i + 1);

			if (payMethodName.contains("PAY LATER")) {

				System.out.println("Pay Later Option is present on the No. " + (i + 1) + " position");

				String xpathactual = payMethodList.get(i).toString();

				String[] xpathact1 = xpathactual.split("xpath:");

				String xpathact2 = xpathact1[1].replace("/div/div[2]]", "/div/div[2]");

				String abc = "(" + xpathact2 + ")[" + pl_position + "]";

				String abc1 = abc.replace("( //div", "(//div");

				Thread.sleep(5000);

				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(abc1))));

				driver.findElement(By.xpath(abc1)).click();

				if (eventPositiononbtn == 0) {

					eventPositiononbtntext = "NO";
				}

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Tata1MGFlowElements.payLaterElement)));

				String actualtext = driver.findElement(By.xpath(Tata1MGFlowElements.payLaterElement)).getText();

				Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");

				String text1 = actualtext + " Option is present on the Payment Page";

				dataList.add(text1);

				dataList.add(eventPositiononbtntext);

				dataValues.put(pl_position, dataList);

				// print command that Simpl is present on the Big Basket- Web Application
				// Checkout Page for email shooting

			}

			else {

				System.out.println("Pay Later Option is not present on the No." + pl_position + " position");

				// print command that Simpl is not present on the Big Basket- Web Application
				// Checkout Page for email shooting

			}

		}

		return dataValues;
	}

}
