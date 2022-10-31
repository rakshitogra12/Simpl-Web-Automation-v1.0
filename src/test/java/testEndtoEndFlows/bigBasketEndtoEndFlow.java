package testEndtoEndFlows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import commonMethods.BaseClass;
import commonMethods.ReadConfig;
import pageObjectFiles.BigbasketFlowElements;
import org.testng.Assert;

public class bigBasketEndtoEndFlow extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	ReadConfig readconfig = new ReadConfig();

	public Map<Integer, ArrayList<String>> bigBasketSuccessTestCode() throws Exception {

		driver.get(readconfig.getbigBasketURL());

		driver.manage().window().maximize();

		int pl_position = 0;

		int eventPositiononbtn = 0;

		String eventPositiononbtntext = null;

		ArrayList<String> dataList = new ArrayList<String>();

		Map<Integer, ArrayList<String>> dataValues = new HashMap<Integer, ArrayList<String>>();

		driver.findElement(By.linkText(BigbasketFlowElements.Login)).click();

		driver.findElement(By.id(BigbasketFlowElements.OTP)).sendKeys(readconfig.getsuccessMobNo());

		driver.findElement(By.xpath(BigbasketFlowElements.Continuebtn)).click();

		Thread.sleep(15000);

		driver.findElement(By.cssSelector(BigbasketFlowElements.VerifyOTPbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.AddItembtn)));

		driver.findElement(By.xpath(BigbasketFlowElements.AddItembtn)).click(); // Add a item here

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.Mybasketbtn)));

		driver.findElement(By.xpath(BigbasketFlowElements.Mybasketbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.Checkoutbtn)));

		driver.findElement(By.xpath(BigbasketFlowElements.Checkoutbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BigbasketFlowElements.Checkoutbtn2)));

		driver.findElement(By.cssSelector(BigbasketFlowElements.Checkoutbtn2)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BigbasketFlowElements.deliverHere)));

		WebElement element1 = driver.findElement(By.cssSelector(BigbasketFlowElements.deliverHere));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.handleCartbtn)));

		WebElement element2 = driver.findElement(By.xpath(BigbasketFlowElements.handleCartbtn));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);

		Thread.sleep(13000);

		System.out.println("Page Load has been successfully completed");

		WebElement element3 = driver.findElement(By.xpath(BigbasketFlowElements.confirmSlotbtn));

		Actions builder = new Actions(driver);

		Action mouseOverHome = builder.moveToElement(element3).click().build();

		Thread.sleep(5000);

		mouseOverHome.perform();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(BigbasketFlowElements.juspayFrame)));

		wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BigbasketFlowElements.payMethodselements)));

		List<WebElement> payMethodList = driver.findElements(By.xpath(BigbasketFlowElements.payMethodselements));
		
		Thread.sleep(10000);

		for (int i = 0; i < payMethodList.size(); i++) {

			String payMethodName = payMethodList.get(i).getText();

			pl_position = (i + 1);

			if (payMethodName.contains("Pay Later")) {

				System.out.println("Pay Later Option is present on the No. " + (i + 1) + " position");

				String xpathactual = payMethodList.get(i).toString();

				String[] xpathact1 = xpathactual.split("xpath:");

				String xpathact2 = xpathact1[1].replaceAll("article]", "article");

				String abc = "(" + xpathact2 + ")[" + pl_position + "]";

				String abc1 = abc.replace(" ", "");
				WebElement element4 = driver.findElement(By.xpath(abc1));

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element4);

				Thread.sleep(13000);

				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(abc1)))).click();

				if (eventPositiononbtn == 0) {

					eventPositiononbtntext = "NO";
				}

				wait.until(
						ExpectedConditions.presenceOfElementLocated(By.xpath(BigbasketFlowElements.payLaterElements)));

				String actualtext = driver.findElement(By.xpath(BigbasketFlowElements.payLaterElements)).getText();
				
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

	public void bigBasketBlockedTestCode() throws InterruptedException {

		driver.get(readconfig.getbigBasketURL());

		driver.manage().window().maximize();

		int pl_position = 0;

		int flag = 0;

		driver.findElement(By.linkText(BigbasketFlowElements.Login)).click();

		driver.findElement(By.id(BigbasketFlowElements.OTP)).sendKeys(readconfig.getblockedMobNo());

		driver.findElement(By.xpath(BigbasketFlowElements.Continuebtn)).click();

		Thread.sleep(15000);

		driver.findElement(By.cssSelector(BigbasketFlowElements.VerifyOTPbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.AddItembtn)));

		driver.findElement(By.xpath(BigbasketFlowElements.AddItembtn)).click(); // Add a item here

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.Mybasketbtn)));

		driver.findElement(By.xpath(BigbasketFlowElements.Mybasketbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.Checkoutbtn)));

		driver.findElement(By.xpath(BigbasketFlowElements.Checkoutbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BigbasketFlowElements.Checkoutbtn2)));

		driver.findElement(By.cssSelector(BigbasketFlowElements.Checkoutbtn2)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BigbasketFlowElements.deliverHere)));

		WebElement element1 = driver.findElement(By.cssSelector(BigbasketFlowElements.deliverHere));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.handleCartbtn)));

		WebElement element2 = driver.findElement(By.xpath(BigbasketFlowElements.handleCartbtn));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);

		Thread.sleep(13000);

		System.out.println("Page Load has been successfully completed");

		WebElement element3 = driver.findElement(By.xpath(BigbasketFlowElements.confirmSlotbtn));

		Actions builder = new Actions(driver);

		Action mouseOverHome = builder.moveToElement(element3).click().build();

		Thread.sleep(5000);

		mouseOverHome.perform();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(BigbasketFlowElements.juspayFrame)));

		wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BigbasketFlowElements.payMethodselements)));

		List<WebElement> payMethodList = driver.findElements(By.xpath(BigbasketFlowElements.payMethodselements));

		Thread.sleep(10000);

		for (int i = 0; i < payMethodList.size(); i++) {

			String payMethodName = payMethodList.get(i).getText();

			pl_position = (i + 1);

			if (payMethodName.contains("Pay Later")) {

				System.out.println("Pay Later Option is present on the No. " + (i + 1) + " position");

				String xpathactual = payMethodList.get(i).toString();

				String[] xpathact1 = xpathactual.split("xpath:");

				String xpathact2 = xpathact1[1].replaceAll("article]", "article");

				String abc = "(" + xpathact2 + ")[" + pl_position + "]";

				String abc1 = abc.replace(" ", "");

				WebElement element4 = driver.findElement(By.xpath(abc1));

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element4);

				Thread.sleep(13000);

				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(abc1)))).click();

				wait.until(
						ExpectedConditions.presenceOfElementLocated(By.xpath(BigbasketFlowElements.payLaterElements)));

				String actualtext = driver.findElement(By.xpath(BigbasketFlowElements.payLaterElements)).getText();

				Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");

			}

			if (!payMethodName.contains("Pay Later")) {

				System.out.println("Pay Later Option is not present on the No." + pl_position + " position");

				flag++;

				// print command that Simpl is not present on the Big Basket- Web Application
				// Checkout Page for email shooting

			}
			if (!payMethodName.contains("Pay Later") && flag == payMethodList.size()) {

				System.out.println("Pay Later Option is not present for this particular user");

			}

		}

	}

	public void bigBasketInsufficentCreditTestCode() throws InterruptedException {

		driver.get(readconfig.getbigBasketURL());

		driver.manage().window().maximize();

		int pl_position = 0;

		int flag = 0;

		driver.findElement(By.linkText(BigbasketFlowElements.Login)).click();

		driver.findElement(By.id(BigbasketFlowElements.OTP)).sendKeys("8904085564");

		driver.findElement(By.xpath(BigbasketFlowElements.Continuebtn)).click();

		Thread.sleep(20000);

		driver.findElement(By.cssSelector(BigbasketFlowElements.VerifyOTPbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.AddItembtn)));

		driver.findElement(By.xpath(BigbasketFlowElements.AddItembtn)).click(); // Add a item here

		Thread.sleep(10000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.Mybasketbtn)));

		driver.findElement(By.xpath(BigbasketFlowElements.Mybasketbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.Checkoutbtn)));

		driver.findElement(By.xpath(BigbasketFlowElements.Checkoutbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BigbasketFlowElements.Checkoutbtn2)));

		driver.findElement(By.cssSelector(BigbasketFlowElements.Checkoutbtn2)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BigbasketFlowElements.deliverHere)));

		WebElement element1 = driver.findElement(By.cssSelector(BigbasketFlowElements.deliverHere));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.handleCartbtn)));

		WebElement element2 = driver.findElement(By.xpath(BigbasketFlowElements.handleCartbtn));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);

		Thread.sleep(13000);

		System.out.println("Page Load has been successfully completed");

		WebElement element3 = driver.findElement(By.xpath(BigbasketFlowElements.confirmSlotbtn));

		Actions builder = new Actions(driver);

		Action mouseOverHome = builder.moveToElement(element3).click().build();

		Thread.sleep(5000);

		mouseOverHome.perform();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(BigbasketFlowElements.juspayFrame)));

		wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BigbasketFlowElements.payMethodselements)));

		List<WebElement> payMethodList = driver.findElements(By.xpath(BigbasketFlowElements.payMethodselements));

		Thread.sleep(10000);

		for (int i = 0; i < payMethodList.size(); i++) {

			String payMethodName = payMethodList.get(i).getText();

			pl_position = (i + 1);

			if (payMethodName.contains("Pay Later")) {

				System.out.println("Pay Later Option is present on the No. " + (i + 1) + " position");

				String xpathactual = payMethodList.get(i).toString();

				String[] xpathact1 = xpathactual.split("xpath:");

				String xpathact2 = xpathact1[1].replaceAll("article]", "article");

				String abc = "(" + xpathact2 + ")[" + pl_position + "]";

				String abc1 = abc.replace(" ", "");

				WebElement element4 = driver.findElement(By.xpath(abc1));

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element4);

				Thread.sleep(13000);

				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(abc1)))).click();

				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.payLaterElements)));

				driver.findElement(By.xpath(BigbasketFlowElements.payLaterElements)).click();

				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//div[@class='linearLayout ' and @id='578']/div/article")));

				driver.findElement(By.xpath("//div[@class='linearLayout ' and @id='578']/div/article")).click();

				Thread.sleep(10000);

				wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='transaction-flow-banner']/p")));

				String text = driver.findElement(By.xpath("//div[@class='transaction-flow-banner']/p")).getText();

				System.out.println(text);

//				Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");

			}

			if (!payMethodName.contains("Pay Later")) {

				System.out.println("Pay Later Option is not present on the No." + pl_position + " position");

				flag++;

				// print command that Simpl is not present on the Big Basket- Web Application
				// Checkout Page for email shooting

			}

			if (!payMethodName.contains("Pay Later") && flag == payMethodList.size()) {

				System.out.println("Pay Later Option is not present for this particular user");

			}

		}

	}

	public void bigBasketUnableToProcessTestCode() throws InterruptedException {

		driver.get(readconfig.getbigBasketURL());

		driver.manage().window().maximize();

		int pl_position = 0;

		int flag = 0;

		driver.findElement(By.linkText(BigbasketFlowElements.Login)).click();

		driver.findElement(By.id(BigbasketFlowElements.OTP)).sendKeys(readconfig.getsuccessMobNo());

		driver.findElement(By.xpath(BigbasketFlowElements.Continuebtn)).click();

		Thread.sleep(15000);

		driver.findElement(By.cssSelector(BigbasketFlowElements.VerifyOTPbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.AddItembtn)));

		driver.findElement(By.xpath(BigbasketFlowElements.AddItembtn)).click(); // Add a item here

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.Mybasketbtn)));

		driver.findElement(By.xpath(BigbasketFlowElements.Mybasketbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.Checkoutbtn)));

		driver.findElement(By.xpath(BigbasketFlowElements.Checkoutbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BigbasketFlowElements.Checkoutbtn2)));

		driver.findElement(By.cssSelector(BigbasketFlowElements.Checkoutbtn2)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BigbasketFlowElements.deliverHere)));

		WebElement element1 = driver.findElement(By.cssSelector(BigbasketFlowElements.deliverHere));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.handleCartbtn)));

		WebElement element2 = driver.findElement(By.xpath(BigbasketFlowElements.handleCartbtn));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);

		Thread.sleep(13000);

		System.out.println("Page Load has been successfully completed");

		WebElement element3 = driver.findElement(By.xpath(BigbasketFlowElements.confirmSlotbtn));

		Actions builder = new Actions(driver);

		Action mouseOverHome = builder.moveToElement(element3).click().build();

		Thread.sleep(5000);

		mouseOverHome.perform();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(BigbasketFlowElements.juspayFrame)));

		wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BigbasketFlowElements.payMethodselements)));

		List<WebElement> payMethodList = driver.findElements(By.xpath(BigbasketFlowElements.payMethodselements));

		Thread.sleep(10000);

		for (int i = 0; i < payMethodList.size(); i++) {

			String payMethodName = payMethodList.get(i).getText();

			pl_position = (i + 1);

			if (payMethodName.contains("Pay Later")) {

				System.out.println("Pay Later Option is present on the No. " + (i + 1) + " position");

				String xpathactual = payMethodList.get(i).toString();

				String[] xpathact1 = xpathactual.split("xpath:");

				String xpathact2 = xpathact1[1].replaceAll("article]", "article");

				String abc = "(" + xpathact2 + ")[" + pl_position + "]";

				String abc1 = abc.replace(" ", "");

				WebElement element4 = driver.findElement(By.xpath(abc1));

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element4);

				Thread.sleep(13000);

				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(abc1)))).click();

				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.payLaterElements)));

				driver.findElement(By.xpath(BigbasketFlowElements.payLaterElements)).click();

				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//div[@class='linearLayout ' and @id='578']/div/article")));

				driver.findElement(By.xpath("//div[@class='linearLayout ' and @id='578']/div/article")).click();

				Thread.sleep(20000);

				wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//div[@class='transaction-flow-banner']/p")));

				String text = driver.findElement(By.xpath("//div[@class='transaction-flow-banner']/p")).getText();

				System.out.println(text);

//					Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");

			}

			if (!payMethodName.contains("Pay Later")) {

				System.out.println("Pay Later Option is not present on the No." + pl_position + " position");

				flag++;

				// print command that Simpl is not present on the Big Basket- Web Application
				// Checkout Page for email shooting

			}

			if (!payMethodName.contains("Pay Later") && flag == payMethodList.size()) {

				System.out.println("Pay Later Option is not present for this particular user");

			}

		}

	}

	public void bigBasketpendingBillTestCode() throws InterruptedException {

		driver.get(readconfig.getbigBasketURL());

		driver.manage().window().maximize();

		int pl_position = 0;

		int flag = 0;

		driver.findElement(By.linkText(BigbasketFlowElements.Login)).click();

		driver.findElement(By.id(BigbasketFlowElements.OTP)).sendKeys(readconfig.getpendingbillNo());

		driver.findElement(By.xpath(BigbasketFlowElements.Continuebtn)).click();

		Thread.sleep(15000);

		driver.findElement(By.cssSelector(BigbasketFlowElements.VerifyOTPbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.AddItembtn)));

		driver.findElement(By.xpath(BigbasketFlowElements.AddItembtn)).click(); // Add a item here

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.Mybasketbtn)));

		driver.findElement(By.xpath(BigbasketFlowElements.Mybasketbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.Checkoutbtn)));

		driver.findElement(By.xpath(BigbasketFlowElements.Checkoutbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BigbasketFlowElements.Checkoutbtn2)));

		driver.findElement(By.cssSelector(BigbasketFlowElements.Checkoutbtn2)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BigbasketFlowElements.deliverHere)));

		WebElement element1 = driver.findElement(By.cssSelector(BigbasketFlowElements.deliverHere));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.handleCartbtn)));

		WebElement element2 = driver.findElement(By.xpath(BigbasketFlowElements.handleCartbtn));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);

		Thread.sleep(13000);

		System.out.println("Page Load has been successfully completed");

		WebElement element3 = driver.findElement(By.xpath(BigbasketFlowElements.confirmSlotbtn));

		Actions builder = new Actions(driver);

		Action mouseOverHome = builder.moveToElement(element3).click().build();

		Thread.sleep(5000);

		mouseOverHome.perform();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(BigbasketFlowElements.juspayFrame)));

		wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BigbasketFlowElements.payMethodselements)));

		List<WebElement> payMethodList = driver.findElements(By.xpath(BigbasketFlowElements.payMethodselements));

		Thread.sleep(10000);

		for (int i = 0; i < payMethodList.size(); i++) {

			String payMethodName = payMethodList.get(i).getText();

			pl_position = (i + 1);

			if (payMethodName.contains("Pay Later")) {

				System.out.println("Pay Later Option is present on the No. " + (i + 1) + " position");

				String xpathactual = payMethodList.get(i).toString();

				String[] xpathact1 = xpathactual.split("xpath:");

				String xpathact2 = xpathact1[1].replaceAll("article]", "article");

				String abc = "(" + xpathact2 + ")[" + pl_position + "]";

				String abc1 = abc.replace(" ", "");

				WebElement element4 = driver.findElement(By.xpath(abc1));

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element4);

				Thread.sleep(13000);

				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(abc1)))).click();

				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.payLaterElements)));

				driver.findElement(By.xpath(BigbasketFlowElements.payLaterElements)).click();

				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//div[@class='linearLayout ' and @id='578']/div/article")));

				driver.findElement(By.xpath("//div[@class='linearLayout ' and @id='578']/div/article")).click();

				Thread.sleep(20000);

				wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//div[@class='transaction-flow-banner']/p")));

				String text = driver.findElement(By.xpath("//div[@class='transaction-flow-banner']/p")).getText();

				System.out.println(text);

//					Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");

			}

			if (!payMethodName.contains("Pay Later")) {

				System.out.println("Pay Later Option is not present on the No." + pl_position + " position");

				flag++;

				// print command that Simpl is not present on the Big Basket- Web Application
				// Checkout Page for email shooting

			}

			if (!payMethodName.contains("Pay Later") && flag == payMethodList.size()) {

				System.out.println("Pay Later Option is not present for this particular user");

			}

		}

	}

	public void bigBasketOtherScenarioCode() throws InterruptedException {

		driver.get(readconfig.getbigBasketURL());

		driver.manage().window().maximize();

		int pl_position = 0;

		int flag = 0;

		driver.findElement(By.linkText(BigbasketFlowElements.Login)).click();

		driver.findElement(By.id(BigbasketFlowElements.OTP)).sendKeys(readconfig.getpendingbillNo());

		driver.findElement(By.xpath(BigbasketFlowElements.Continuebtn)).click();

		Thread.sleep(15000);

		driver.findElement(By.cssSelector(BigbasketFlowElements.VerifyOTPbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.AddItembtn)));

		driver.findElement(By.xpath(BigbasketFlowElements.AddItembtn)).click(); // Add a item here

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.Mybasketbtn)));

		driver.findElement(By.xpath(BigbasketFlowElements.Mybasketbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.Checkoutbtn)));

		driver.findElement(By.xpath(BigbasketFlowElements.Checkoutbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BigbasketFlowElements.Checkoutbtn2)));

		driver.findElement(By.cssSelector(BigbasketFlowElements.Checkoutbtn2)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BigbasketFlowElements.deliverHere)));

		WebElement element1 = driver.findElement(By.cssSelector(BigbasketFlowElements.deliverHere));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.handleCartbtn)));

		WebElement element2 = driver.findElement(By.xpath(BigbasketFlowElements.handleCartbtn));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);

		Thread.sleep(13000);

		System.out.println("Page Load has been successfully completed");

		WebElement element3 = driver.findElement(By.xpath(BigbasketFlowElements.confirmSlotbtn));

		Actions builder = new Actions(driver);

		Action mouseOverHome = builder.moveToElement(element3).click().build();

		Thread.sleep(5000);

		mouseOverHome.perform();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(BigbasketFlowElements.juspayFrame)));

		wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BigbasketFlowElements.payMethodselements)));

		List<WebElement> payMethodList = driver.findElements(By.xpath(BigbasketFlowElements.payMethodselements));

		Thread.sleep(10000);

		for (int i = 0; i < payMethodList.size(); i++) {

			String payMethodName = payMethodList.get(i).getText();

			pl_position = (i + 1);

			if (payMethodName.contains("Pay Later")) {

				System.out.println("Pay Later Option is present on the No. " + (i + 1) + " position");

				String xpathactual = payMethodList.get(i).toString();

				String[] xpathact1 = xpathactual.split("xpath:");

				String xpathact2 = xpathact1[1].replaceAll("article]", "article");

				String abc = "(" + xpathact2 + ")[" + pl_position + "]";

				String abc1 = abc.replace(" ", "");

				WebElement element4 = driver.findElement(By.xpath(abc1));

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element4);

				Thread.sleep(13000);

				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(abc1)))).click();

				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BigbasketFlowElements.payLaterElements)));

				driver.findElement(By.xpath(BigbasketFlowElements.payLaterElements)).click();

				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//div[@class='linearLayout ' and @id='578']/div/article")));

				driver.findElement(By.xpath("//div[@class='linearLayout ' and @id='578']/div/article")).click();

				Thread.sleep(20000);

				wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//div[@class='transaction-flow-banner']/p")));

				String text = driver.findElement(By.xpath("//div[@class='transaction-flow-banner']/p")).getText();

				System.out.println(text);

//					Assert.assertEquals(actualtext, "Simpl", "Simpl Option is not present on the Payment Page");

			}

			if (!payMethodName.contains("Pay Later")) {

				System.out.println("Pay Later Option is not present on the No." + pl_position + " position");

				flag++;

				// print command that Simpl is not present on the Big Basket- Web Application
				// Checkout Page for email shooting

			}

			if (!payMethodName.contains("Pay Later") && flag == payMethodList.size()) {

				System.out.println("Pay Later Option is not present for this particular user");

			}

		}

	}

}
